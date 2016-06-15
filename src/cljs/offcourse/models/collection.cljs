(ns offcourse.models.collection
  (:require [schema.core :as schema :include-macros true]))

(schema/defrecord Collection
    [collection-type  :- schema/Keyword
     collection-name  :- schema/Keyword])

(defn new
  ([collection-data] (map->Collection collection-data))
  ([collection-type collection-name]
  (->Collection collection-type collection-name)))
