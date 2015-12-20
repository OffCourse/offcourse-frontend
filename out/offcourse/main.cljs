(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [com.stuartsierra.component :as component]
            [offcourse.core :refer [render]]))

(defonce db (pouchdb/new-pouch "Offcourse-Sample"))

(defn init []
  (do
    (enable-console-print!)
    (println "1...2...3... lift off!")
    (component/start db)))

(defn reload []
  (enable-console-print!)
  (println "Entering hyperspace")
  (render))

(defn stop []
  (component/stop db))
