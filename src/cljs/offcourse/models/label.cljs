(ns offcourse.models.label
  (:require [schema.core :as schema :include-macros true]
            [medley.core :as medley]))

(schema/defrecord Label
    [label-name :- schema/Keyword])


(defn new [label-name selected]
  (map->Label {:label-name label-name}))

(defn select [selected {:keys [label-name] :as label}]
  (if (= label-name selected)
    (with-meta label {:selected? true})
    label))

(defn collection->labels
  ([collection] (collection->labels collection nil))
  ([collection selected]
   (->> collection
        (map (comp (partial select selected) new))
        (into #{}))))
