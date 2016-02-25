(ns offcourse.models.collection
  (:require [schema.core :as schema :include-macros true]
            [offcourse.models.course :as co]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Collection
    [collection-type  :- schema/Keyword
     collection-name  :- schema/Keyword
     course-ids       :- #{schema/Num}])

(defn new-collection [collection-type collection-name]
  (->Collection collection-type collection-name nil))

(defn new
  ([collection-data] (map->Collection collection-data))
  ([collection-type collection-name]
  (->Collection collection-type collection-name nil)))
