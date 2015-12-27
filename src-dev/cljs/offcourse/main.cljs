(ns offcourse.main
  (:require [cljs.core.async :refer [<! put!]]
            [OffcourseDesignDocs]
            [offcourse.protocols.queryable :as qa]
            [com.stuartsierra.component :as component]
            [offcourse.core :as core])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defonce app (atom nil))

(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app design-doc))
    #_(put! (:api-input @app) {:hello "world"})
    (reset! app (component/start @app))))

(defn reload []
  (go
    (enable-console-print!)
    (put! (:api-input @app) (<! (qa/fetch (:api @app) {:key "123abbc"})))
    (println "Re-Entering hyperspace...!")
    #_(put! (:api-input @app) {:hello (str "world again")})))

(defn stop []
  (component/stop @app))
