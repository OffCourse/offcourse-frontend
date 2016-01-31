(ns offcourse.viewmodels.checkpoint-view.index
  (:require [offcourse.viewmodels.checkpoint-view.queryable :as qa-impl]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
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

(defn new [{:keys [type course-id checkpoint-id curator hashtag]}]
  (let [course (if course-id {:course-id course-id}
                   {:curator curator
                    :hashtag hashtag})]
    (map->CheckpointView {:view-name type
                          :checkpoint-id (js/parseInt checkpoint-id)
                          :course course})))
