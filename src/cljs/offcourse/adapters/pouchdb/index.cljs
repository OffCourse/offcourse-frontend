(ns offcourse.adapters.pouchdb.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.bootstrappable :refer [Bootstrappable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.adapters.pouchdb.implementations.bootstrappable :refer [bootstrap]]
            [offcourse.adapters.pouchdb.implementations.queryable.fetch :refer [fetch]]
            [offcourse.adapters.pouchdb.implementations.queryable.check :refer [check]]
            [offcourse.adapters.pouchdb.implementations.queryable.refresh :refer [refresh]]
            [offcourse.adapters.pouchdb.implementations.validatable :refer [valid?]]
            [wrappers.pouchdb :as wrapper]))

(defrecord PouchDB [name bootstrap-docs connection]
  Lifecycle
  (start [db] (assoc db :connection (wrapper/init (:name db))))
  (stop  [db] (dissoc db :connection))
  Bootstrappable
  (bootstrap [db] (bootstrap db))
  Queryable
  (check   [db query] (check db query))
  (fetch   [db query] (fetch (:connection db) query))
  (refresh [db query] (refresh db query))
  Validatable
  (valid? [db] (valid? db))
  Responsive
  (respond [db status] (ri/-respond db status nil)))

(defn new-db [name bootstrap-docs]
  (map->PouchDB {:name name
                 :bootstrap-docs bootstrap-docs}))
