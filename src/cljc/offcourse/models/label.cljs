(ns offcourse.models.label
  (:require [schema.core :as schema :include-macros true]
            [medley.core :as medley]))

(schema/defrecord Label
    [label-name :- schema/Keyword
     selected? :- schema/Bool
     highlighted? :- schema/Bool])

(defn new [label-name]
  (map->Label {:label-name label-name
               :selected? false
               :highlighted? false}))

(defn collection->labels [collection]
  (->> collection
       (map new)
       (into #{})))
