(ns adapters.pouchdb.index
  (:require [com.stuartsierra.component :as component :refer [Lifecycle]]
            [adapters.pouchdb.wrapper :as wrapper]
            [offcourse.protocols.bootstrappable :refer [Bootstrappable]]
            [adapters.pouchdb.implementations.bootstrappable :as ba]
            [adapters.pouchdb.implementations.validatable :as va]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :refer [Validatable]]))

(defrecord PouchDB [name design-doc bootstrap-doc connection]
  Lifecycle
  (start [db] (assoc db :connection (wrapper/init (:name db))))
  (stop [db] (dissoc db :connection))
  Bootstrappable
  (bootstrap [db] (ba/bootstrap db))
  Queryable
  (fetch [db query]
    (wrapper/fetch (:connection db) {:key (get-in query [:course :id])}))

  Validatable
  (errors-async [db] (va/errors-async db))
  (valid?-async [db] (va/valid?-async db)))

(defn new-db [name design-doc bootstrap-doc]
  (map->PouchDB {:name name
                 :design-doc design-doc
                 :bootstrap-doc bootstrap-doc}))
