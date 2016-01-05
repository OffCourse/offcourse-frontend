(ns offcourse.main
  (:require [cljs.core.async :refer [put!]]
            [OffcourseDesignDocs]
            [com.stuartsierra.component :as component]
            [offcourse.sample-queries :refer [sample-query]]
            [offcourse.core :as core]))

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
    (put! (:api-input @app) sample-query)))

(defn stop []
  (component/stop @app))
