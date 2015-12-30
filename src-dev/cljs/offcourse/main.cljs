(ns offcourse.main
  (:require [cljs.core.async :refer [<! put!]]
            [OffcourseDesignDocs]
            [offcourse.protocols.queryable :as qa]
            [com.stuartsierra.component :as component]
            [offcourse.core :as core])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defonce sample-payload {:type :collection
                         :collection {:collection-type :tags
                                      :collection-name :spam}})

(def sample-query {:type :not-found-data
                   :payload sample-payload})

(defonce app (atom nil))

(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app design-doc))
    (reset! app (component/start @app))
    (put! (:api-input @app) sample-query)))

(defn reload []
  (do
    (enable-console-print!)
    (put! (:api-input @app) sample-query)
    (println "Re-Entering hyperspace...!!")))

(defn stop []
  (component/stop @app))
