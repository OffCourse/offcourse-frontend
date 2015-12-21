(ns offcourse.adapters.pouchdb.index
  (:require [cljs.core.async :refer [<! >! pipe chan]]
            [com.stuartsierra.component :as component]
            [cljsjs.pouchdb]
            [offcourse.helpers.interop :refer [jsx->clj handle-json-response]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init-db [str]
  (js/PouchDB. str))

(defrecord PouchDB [local-name local-connection]
  component/Lifecycle
  (start [this]
    (let [db (init-db local-name)]
      (println "initialized" local-name)
      (assoc this :local-connection db)))
  (stop [this]
    (do
      (dissoc this :local-connection)
      (println "stopped" (:local-name this)))))

(defn new-pouch [local-name]
  (map->PouchDB {:local-name local-name}))

(defn info [pouch]
  (handle-json-response (.info (:local-connection pouch))))

(defn fetch [pouch doc-id]
  (handle-json-response (.get (:local-connection pouch) doc-id)))

(defn refresh [pouch doc]
  (handle-json-response (.put (:local-connection pouch) doc)))

(defn update-design-doc [db doc]
  (let [channel (chan)]
    (go
      (let [{:keys [error] :as response} (<! (refresh db doc))]
        (>! channel (or error response))))
      channel))

(defn bootstrap-db [db design-doc]
  (let [channel (chan)]
    (go
      (let [doc-id (:_id (jsx->clj design-doc))
            {:keys [error] :as response} (<! (fetch db doc-id))]
        (if error
          (pipe (update-design-doc db design-doc) channel)
          (>! channel response))))
    channel))
