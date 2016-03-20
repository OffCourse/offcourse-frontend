(ns offcourse.models.checkpoint
  (:require [schema.core :as schema :include-macros true]))

(schema/defrecord Checkpoint
    [checkpoint-id   :- (schema/cond-pre schema/Num (schema/enum :new))
     checkpoint-slug :- schema/Str
     url             :- schema/Str
     task            :- schema/Str
     tags            :- #{schema/Keyword}])

(def placeholder
  (map->Checkpoint {:checkpoint-id :new
                    :url "abc"
                    :task "Add Something"
                    :tags #{}}))

(defn new [overrides] (map->Checkpoint overrides))
