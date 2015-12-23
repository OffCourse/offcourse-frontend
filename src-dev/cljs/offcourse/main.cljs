(ns offcourse.main
  (:require [cljs.core.async :refer [put!]]
            [OffcourseDesignDocs]
            [com.stuartsierra.component :as component]
            [offcourse.core :as core]))

(defonce app (atom nil))

(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app design-doc))
    #_(put! (:api-input @app) {:hello "world"})
    (reset! app (component/start @app))))

(defn reload []
  (do
    (enable-console-print!)
    (println "Re-Entering hyperspace...!")
    #_(put! (:api-input @app) {:hello (str "world again")})))

(defn stop []
  (component/stop @app))
