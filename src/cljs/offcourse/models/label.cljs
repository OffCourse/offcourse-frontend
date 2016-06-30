(ns offcourse.models.label)

(defrecord Label [])

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
