(ns offcourse.models.checkpoint.index
  (:require [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.models.checkpoint.refresh :as refresh-impl]
            [offcourse.models.checkpoint.add :as add-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [cljs.spec :as spec]
            [offcourse.specs.checkpoints :as specs]))

(defrecord Checkpoint []
  Validatable
  (-valid? [checkpoint] (spec/valid? ::specs/checkpoint checkpoint))
  Queryable
  (-check [checkpoint] (spec/explain ::specs/checkpoint checkpoint))
  (-add [checkpoint query] (add-impl/add checkpoint query))
  (-refresh [checkpoint query] (refresh-impl/refresh checkpoint query)))

(def defaults {:tags #{}
                :completed? false})

(defn new
  ([] (map->Checkpoint defaults))
  ([overrides] (map->Checkpoint (merge defaults overrides))))
