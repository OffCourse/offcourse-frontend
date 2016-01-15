(ns offcourse.models.checkpoint-view.index
  (:require [offcourse.models.checkpoint-view.queryable :as qa-impl]
            [offcourse.models.checkpoint-view.validatable :as va-impl]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]
            [offcourse.models.label :refer [Label]]))

(schema/defrecord CheckpointView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     checkpoint-id :- schema/Num
     resource :- Resource]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CheckpointView vm))
  (refresh [vm store] (qa-impl/refresh vm store)))

(defn new [{:keys [type course-id checkpoint-id]}]
  (let [course {:course-id course-id}]
    (map->CheckpointView {:view-name type
                          :course course
                          :checkpoint-id checkpoint-id})))
