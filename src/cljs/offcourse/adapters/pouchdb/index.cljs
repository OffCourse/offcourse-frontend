(ns offcourse.adapters.pouchdb.index
  (:require [cljs.core.async :refer [<! chan put! take!]]
            [com.stuartsierra.component :as component]
            [cljsjs.pouchdb])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init-db [str]
  (js/PouchDB. str))

(defn handle-promise
  ([promise]
   (handle-promise promise identity))
  ([promise cb] (let [channel (chan)]
                  (-> promise
                      (.then #(put! channel (cb %1))))
                  channel)))

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

(defn info [pouch cb]
  (handle-promise (.info (:local-connection pouch)) cb))
