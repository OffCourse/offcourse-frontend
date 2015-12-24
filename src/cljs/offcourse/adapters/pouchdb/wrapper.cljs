(ns offcourse.adapters.pouchdb.wrapper
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [cljsjs.pouchdb]
            [offcourse.helpers.interop :refer [jsx->clj handle-json-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn init [name]
  (js/PouchDB. name))

(defn info [pouch]
  (handle-json-response (.info pouch)))

(defn fetch-doc [pouch doc-id]
  (handle-json-response (.get pouch doc-id)))

(defn refresh-doc [pouch doc]
  (handle-json-response (.put pouch doc)))

(defn has-doc? [pouch doc]
  (let [doc-id (:_id (jsx->clj doc))
        channel (chan)]
    (go
      (if-let [error (:error (<! (fetch-doc pouch doc-id)))]
        (>! channel false)
        (>! channel true)))
    channel))
