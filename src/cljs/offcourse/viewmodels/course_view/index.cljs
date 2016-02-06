(ns offcourse.viewmodels.course-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.viewmodels.course-view.queryable :as qa-impl]
            [offcourse.viewmodels.course-view.validatable :as va-impl]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [schema.core :as schema :include-macros true]
            [offcourse.models.label :as lb :refer [Label]]))

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

(defn new [{:keys [type course] :as as} {:keys [courses resources] :as ds}]
  (let [course       (or (qa/get ds :course course) course)
        tags         (co/get-tags course)
        labels       {:tags (lb/collection->labels tags)}
        resource-ids (co/get-resource-ids course)
        resources    (qa/get ds :resources resource-ids)]
     (->CourseView type labels course resources)))
