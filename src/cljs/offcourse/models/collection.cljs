(ns offcourse.models.collection)

(defrecord Collection [collection-type collection-name])

(defn new
  ([collection-data] (map->Collection collection-data))
  ([collection-type collection-name]
  (->Collection collection-type collection-name)))
