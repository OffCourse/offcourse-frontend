(ns adapters.pouchdb.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.bootstrappable :refer [Bootstrappable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [adapters.pouchdb.implementations.bootstrappable :as ba-impl]
            [adapters.pouchdb.implementations.queryable :as qa-impl]
            [adapters.pouchdb.implementations.validatable :as va-impl]
            [adapters.pouchdb.wrapper :as wrapper]))

(defrecord PouchDB [name bootstrap-docs connection]
  Lifecycle
  (start [db] (assoc db :connection (wrapper/init (:name db))))
  (stop [db] (dissoc db :connection))
  Bootstrappable
  (bootstrap [db] (ba-impl/bootstrap db))
  Queryable
  (check [db query] (qa-impl/check db query))
  (fetch [db query] (qa-impl/fetch db query))
  (refresh [db query] (qa-impl/refresh db query))
  Validatable
  (valid? [db] (va-impl/valid? db)))

(defn new-db [name bootstrap-docs]
  (map->PouchDB {:name name
                 :bootstrap-docs bootstrap-docs}))
