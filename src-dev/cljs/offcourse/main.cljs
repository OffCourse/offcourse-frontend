(ns offcourse.main
  (:require [cljs.core.async :refer [put!]]
            #_[OffcourseDesignDocs]
            [offcourse.fake-data.index :as fake-data]
            [com.stuartsierra.component :as component]
            [offcourse.sample-queries :refer [sample-query]]
            [offcourse.sample-route-requests :refer [sample-request]]
            [offcourse.core :as core]))

(defonce app (atom nil))
#_(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn add-db-id [doc]
  #_(assoc doc :_id (str (:base-id doc)))
  (assoc doc :_id  "56886142-cce5-4a40-ba61-d1ff9c34cf9f"))

(defn init []
  (let [bd              (fake-data/generate-course)
        bootstrap-doc   (clj->js (add-db-id bd))]
    (do
      (enable-console-print!)
      (reset! app (core/app [#_design-doc bootstrap-doc]))
      (reset! app (component/start @app))
      #_(put! (:router-output @app) sample-request))))

(defn reload []
  (do
    (enable-console-print!)
    #_(put! (:router-output @app) sample-request)))

(defn stop []
  (component/stop @app))
