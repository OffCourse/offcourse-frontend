(ns offcourse.models.checkpoint
  (:require [schema.core :as schema :include-macros true]))

(schema/defrecord Checkpoint
    [checkpoint-id :- schema/Num
     resource-id   :- schema/Str
     order         :- schema/Num
     task          :- schema/Str
     tags          :- #{schema/Keyword}])
