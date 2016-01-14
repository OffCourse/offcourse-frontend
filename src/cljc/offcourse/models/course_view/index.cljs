(ns offcourse.models.course-view.index
  (:require [schema.core :as schema :include-macros true]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [medley.core :as medley]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.models.course-view.queryable :as qa-impl]
            [offcourse.models.course-view.validatable :as va-impl]))

(schema/defrecord CourseView
    [view-name :- Keyword
     labels :- {Keyword schema/Any}
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


