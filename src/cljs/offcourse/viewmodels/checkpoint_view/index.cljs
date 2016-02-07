(ns offcourse.viewmodels.checkpoint-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
            [schema.core :as schema :include-macros true]))

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
  (refresh [vm store] #_(qa-impl/refresh vm store)))

(defn new
  ([{:keys [type course checkpoint-id] :as as} {:keys [courses resources] :as ds}]
   (let [course       (or (qa/get ds :course course) course)
         tags         (co/get-tags course)
         labels       {:tags (lb/collection->labels tags)}
         resource-id  (co/get-resource-id course checkpoint-id)
         resource     (qa/get ds :resource {:resource-id resource-id})]
     (->CheckpointView type labels course checkpoint-id resource))))
