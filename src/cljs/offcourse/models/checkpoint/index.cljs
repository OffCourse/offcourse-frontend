(ns offcourse.models.checkpoint.index
  (:require [schema.core :as schema :include-macros true]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.models.checkpoint.refresh :as refresh-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Checkpoint
    [checkpoint-slug :- schema/Str
     url             :- schema/Str
     task            :- schema/Str
     tags            :- #{schema/Keyword}]
  {(schema/optional-key :checkpoint-id) schema/Int}
  Validatable
  (-valid? [{:keys [checkpoints] :as course}]
    (not (qa/check course)))
  Queryable
  (-check [checkpoint] (schema/check Checkpoint checkpoint))
  (-refresh [checkpoint query] (refresh-impl/refresh checkpoint query)))

(defn new [overrides] (map->Checkpoint overrides))