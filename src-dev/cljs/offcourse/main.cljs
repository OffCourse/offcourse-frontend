(ns offcourse.main
  (:require [cljs.core.async :refer [chan timeout put! <!]]
            [com.stuartsierra.component :as component]
            [OffcourseDesignDocs]
            [offcourse.adapters.pouchdb :as pouchdb]
            [offcourse.api.index :as api-service]
            [com.stuartsierra.component :as component]
            [offcourse.core :as app])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(let [design-doc (.-course js/OffcourseDesignDocs)]
  (defonce db (pouchdb/init-db "Offcourse-Sample" design-doc))
  (defonce api-output (chan 10))
  (defonce api-input (chan 10))
  (defonce new-api (api-service/new-api db api-output api-input))
  (defonce counter (atom 0)))

(defn listen [api]
  (go-loop []
    (let [val (<! api-output)]
      (app/render val))
    (recur)))

(defn init []
  (do
    (enable-console-print!)
    (put! api-input {:hello "world"})
    (println "1...2...3... lift off!")
    (def api (component/start new-api))
    (listen api)))

(defn reload []
  (go
    (enable-console-print!)
    (swap! counter inc)
    (println "Entering hyperspace...!")
    (>! api-input {:hello "world again! "})))

(defn stop []
  (component/stop api))
