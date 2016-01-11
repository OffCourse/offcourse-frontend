(ns offcourse.main
  (:require [cljs.core.async :refer [put!]]
            [OffcourseDesignDocs]
            [offcourse.fake-data.index :as fake-data]
            [com.stuartsierra.component :as component]
            [offcourse.sample-queries :refer [sample-query]]
            [offcourse.core :as core]))

(set! cljs.core/*print-fn* identity)

(defonce app (atom nil))
(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn add-db-id [doc]
  #_(assoc doc :_id (str (:base-id doc)))
  (assoc doc :_id  "56886142-cce5-4a40-ba61-d1ff9c34cf9f"))

(defn init []
  (let [bd              (fake-data/generate-course)
        bootstrap-doc   (clj->js (add-db-id bd))]
    (do
      (enable-console-print!)
      (reset! app (core/app [design-doc bootstrap-doc]))
      (reset! app (component/start @app))
      (put! (:user-output @app) sample-query))))
