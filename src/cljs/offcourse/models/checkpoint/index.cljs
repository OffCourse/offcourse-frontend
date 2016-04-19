(ns offcourse.models.checkpoint.index
  (:require [schema.core :as schema :include-macros true]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.models.checkpoint.refresh :as refresh-impl]
            [offcourse.models.checkpoint.add :as add-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Checkpoint
    [checkpoint-slug :- schema/Str
     completed?      :- (schema/cond-pre schema/Bool schema/Num)
     url             :- #"https?://.*"
     task            :- schema/Str
     tags            :- #{schema/Keyword}]
  {(schema/optional-key :checkpoint-id) schema/Int}
  Validatable
  (-valid? [{:keys [checkpoints] :as course}]
    (not (qa/check course)))
  Queryable
  (-check [checkpoint] (schema/check Checkpoint checkpoint))
  (-add [checkpoint query] (add-impl/add checkpoint query))
  (-refresh [checkpoint query] (refresh-impl/refresh checkpoint query)))

(def defaults {:tags #{}
                :completed? false})

(defn new
  ([] (map->Checkpoint defaults))
  ([overrides] (map->Checkpoint (merge defaults overrides))))
