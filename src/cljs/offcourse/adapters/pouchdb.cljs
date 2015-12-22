(ns offcourse.adapters.pouchdb
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [cljsjs.pouchdb]
            [offcourse.helpers.interop :refer [jsx->clj handle-json-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn init-db [name design-doc]
  {:name name
   :connection (js/PouchDB. name)
   :design-doc design-doc
   :design-doc-id (:_id (jsx->clj design-doc))})

(defn info [pouch]
  (handle-json-response (.info pouch)))

(defn fetch [pouch doc-id]
  (handle-json-response (.get pouch doc-id)))

(defn refresh [pouch doc]
  (handle-json-response (.put pouch doc)))

(defn bootstrap [{:keys [connection design-doc design-doc-id]}]
  (let [channel (chan)]
    (go
      (if-let [error (:error (<! (fetch connection design-doc-id)))]
        (pipe (refresh connection design-doc) channel)
        (>! channel :updated)))
    channel))
