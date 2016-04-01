(ns offcourse.main
  (:require [cljs.core.async :refer [put!]]
            [offcourse.fake-data.index :as fake-data]
            [com.stuartsierra.component :as component]
            [offcourse.sample-queries :refer [sample-query]]
            [offcourse.core :as core]))

(set! cljs.core/*print-fn* identity)

(defonce app (atom nil))

(defn add-db-id [doc]
  #_(assoc doc :_id (str (:base-id doc)))
  (assoc doc :_id  "56886142-cce5-4a40-ba61-d1ff9c34cf9f"))

(def auth-config {:appId "1729964960615727"
                  :cookie     true
                  :xfbml      true
                  :version    "v2.5"})

(def sample-route-request
  {:type    :requested-route
   :payload {:type            :collection-view
             :collection-type :flags
             :collection-name :new}})

(defn init []
  (let [bd              (fake-data/generate-course)
        bootstrap-doc   (clj->js (add-db-id bd))]
    (do
      (enable-console-print!)
      (reset! app (core/app [bootstrap-doc] auth-config))
      (reset! app (component/start @app)))))
