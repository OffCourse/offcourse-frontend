(ns offcourse.adapters.pouchdb
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [com.stuartsierra.component :as component]
            [cljsjs.pouchdb]
            [offcourse.helpers.interop :refer [jsx->clj handle-json-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defrecord PouchDB [name design-doc connection]
  component/Lifecycle
  (start [db]
    (assoc db :connection (js/PouchDB. (:name db))))
  (stop [db]
    (dissoc db :connection)))

(defn new-db [name design-doc]
  (map->PouchDB {:name name
                 :design-doc design-doc}))

(defn info [pouch]
  (handle-json-response (.info pouch)))

(defn fetch [pouch doc-id]
  (handle-json-response (.get pouch doc-id)))

(defn refresh [pouch doc]
  (handle-json-response (.put pouch doc)))

(defn bootstrap [{:keys [connection design-doc]}]
  (let [channel (chan)
        design-doc-id (:_id (jsx->clj design-doc))]
    (go
      (if-let [error (:error (<! (fetch connection design-doc-id)))]
        (pipe (refresh connection design-doc) channel)
        (>! channel :updated)))
    channel))
