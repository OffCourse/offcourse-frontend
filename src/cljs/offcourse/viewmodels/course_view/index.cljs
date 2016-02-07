(ns offcourse.viewmodels.course-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.course-view.validatable :as va-impl]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CourseView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     resources :- (schema/conditional #(not (nil? %)) [Resource])]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CourseView vm))
  (refresh [vm store] #_(qa-impl/refresh vm store)))

(def graph
  {:view-name    (fnk [view-type] view-type)
   :course       (fnk [datastore course-data]
                      (or (qa/get datastore :course course-data)
                          course-data))
   :tags         (fnk [course] (co/get-tags course))
   :labels       (fnk [tags] {:tags (lb/collection->labels tags)})
   :resource-ids (fnk [course] (co/get-resource-ids course))
   :resources    (fnk [datastore resource-ids]
                      (qa/get datastore :resources resource-ids))})

(def compose (graph/compile graph))

(defn new [{:keys [type course]} datastore]
  (let [view-data (compose {:view-type type
                            :course-data course
                            :datastore datastore})]
    (map->CourseView view-data)))
