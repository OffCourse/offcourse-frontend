(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [com.stuartsierra.component :as component]
            [offcourse.core :refer [render]]))

(defonce dbc (pouchdb/new-pouch "Offcourse-Sample"))
(defonce counter (atom 0))

(defn init []
  (do
    (enable-console-print!)
    (println "1...2...3... lift off!")
    (def db (component/start dbc))
    (render db)))

(defn reload []
  (do
    (enable-console-print!)
    (swap! counter inc)
    (println "Entering hyperspace")
    (println @counter)
    (render db)))

(defn stop []
  (component/stop db))
