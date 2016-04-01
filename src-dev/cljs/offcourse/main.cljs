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

(def auth-config {"appId" "1730376537241236"
                  "cookie"     true
                  "xfbml"      true
                  "version"    "v2.5"})

(def identity-config {"region" "eu-west-1"
                      "IdentityPoolId" "eu-west-1:8ec6381f-02fc-4167-a272-2dd785d8aee2"})

(defn init []
  (let [bd              (fake-data/generate-course)
        bootstrap-doc   (clj->js (add-db-id bd))]
    (do
      (enable-console-print!)
      (reset! app (core/app [#_design-doc bootstrap-doc] auth-config identity-config))
      (reset! app (component/start @app))
      #_(put! (:router-output @app) sample-request))))

(defn reload []
  (do
    (enable-console-print!)
    #_(put! (:router-output @app) sample-request)))

(defn stop []
  (component/stop @app))
