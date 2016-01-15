(ns offcourse.models.course-view.index
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.models.course-view.queryable :as qa-impl]
            [offcourse.models.course-view.validatable :as va-impl]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]
            [offcourse.models.label :refer [Label]]))

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
  (refresh [vm store] (qa-impl/refresh vm store)))

(defn new [{:keys [type course-id]}]
  (let [course {:course-id course-id}]
    (map->CourseView {:view-name type
                      :course course})))


