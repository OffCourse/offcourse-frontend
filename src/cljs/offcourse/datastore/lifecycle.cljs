(ns offcourse.datastore.lifecycle
  (:require [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.queryable :refer [check]]
            [offcourse.protocols.responsive :as ri]))

(defn start [ds]
  (let [ds (assoc ds :store (atom (ds/new)))]
    (assoc ds :listener (ri/listen ds))))

(defn stop  [ds]
  (dissoc ds :store))
