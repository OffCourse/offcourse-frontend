(ns offcourse.adapters.fakedb.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.adapters.fakedb.implementations.queryable :refer [fetch]]))

(defrecord FakeDB [name supported-types connection]
  Lifecycle
  (start [db] db)
  (stop  [db] db)
  Queryable
  (-fetch   [db query] (fetch db query)))

(defn new-db [config]
  (map->FakeDB config))
