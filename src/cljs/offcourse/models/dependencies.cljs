(ns offcourse.models.dependencies
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [medley.core :as medley]))

(defmulti refresh (fn [_ {:keys [type] :as action}]
                    type))

(defmethod refresh :add-checkpoint [dependencies {:keys [checkpoint]}]
  (update-in dependencies [:course] #(qa/add % :checkpoint checkpoint)))

(defmethod refresh :delete-checkpoint [dependencies {:keys [checkpoint]}]
  (update-in dependencies [:course] #(qa/remove % :checkpoint checkpoint)))

(defmethod refresh :update-goal [dependencies {:keys [goal]}]
  (assoc-in dependencies [:course :goal] goal))

(defmethod refresh :update-curator [dependencies {:keys [curator]}]
  (update-in dependencies [:course :curator] #(or % curator)))

(schema/defrecord Dependencies
    [course :- schema/Any]
  Queryable
  (-refresh [dependencies action] (refresh dependencies action)))

(defn new
  ([] (map->Dependencies {}))
  ([overrides] (map->Dependencies overrides)))
