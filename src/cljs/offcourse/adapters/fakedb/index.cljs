(ns offcourse.adapters.fakedb.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.adapters.fakedb.implementations.queryable :refer [fetch]]))

(defrecord FakeDB [name connection]
  Lifecycle
  (start [db] (assoc db :connection "test/test.com"))
  (stop  [db] (dissoc db :connection))
  Queryable
  (check   [db query] #_(check db query))
  (fetch   [db query] (fetch (:connection db) query))
  (refresh [db query] #_(refresh db query))
  Validatable
  (valid? [db] #_(valid? db))
  Responsive
  (respond [db status] (ri/-respond db status nil)))

(defn new-db [name]
  (map->FakeDB {:name name}))
