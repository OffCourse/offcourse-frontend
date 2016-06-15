(ns offcourse.adapters.embedly.index
(:require [com.stuartsierra.component :refer [Lifecycle]]
          [offcourse.adapters.embedly.queryable :as qa-impl]
          [offcourse.protocols.queryable :refer [Queryable]]))

(defrecord Embedly [name supported-types connection]
  Lifecycle
  (start [db] db)
  (stop  [db] db)
  Queryable
  (-fetch   [db query] (qa-impl/fetch db query)))

(defn new-db [config]
  (map->Embedly config))
