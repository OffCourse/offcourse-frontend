(ns offcourse.adapters.aws.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.adapters.aws.queryable :as qa-impl]
            [offcourse.protocols.queryable :refer [Queryable]]))

(defrecord AWS [name supported-types connection]
  Lifecycle
  (start [db] db)
  (stop  [db] db)
  Queryable
  (-fetch   [db query] (qa-impl/fetch db query)))

(defn new-db [name endpoint]
  (map->AWS {:name name
             :endpoint endpoint}))
