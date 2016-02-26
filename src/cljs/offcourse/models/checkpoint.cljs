(ns offcourse.models.checkpoint
  (:require [schema.core :as schema :include-macros true]))

(schema/defrecord Checkpoint
    [checkpoint-id :- (schema/cond-pre schema/Num (schema/enum :new))
     resource-id   :- schema/Str
     order         :- schema/Num
     task          :- schema/Str
     tags          :- #{schema/Keyword}])

(def placeholder
  (map->Checkpoint {:checkpoint-id :new
                    :resource-id "abc"
                    :order 999999
                    :task "Add Something"
                    :tags #{}}))