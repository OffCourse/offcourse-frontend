(ns offcourse.models.collection
  (:require [schema.core :as schema :include-macros true]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [clojure.set :as set]
            [com.rpl.specter :refer [select-first transform]]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(schema/defrecord Collection
    [collection-type  :- schema/Keyword
     collection-name  :- schema/Keyword
     course-ids       :- #{schema/Num}]
  Queryable
  (-refresh [this {:keys [collection]}]
    (update this :course-ids #(set/union % (:course-ids collection)))))

(defn new
  ([collection-data] (map->Collection collection-data))
  ([collection-type collection-name]
  (->Collection collection-type collection-name nil)))
