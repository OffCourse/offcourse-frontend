(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.aws.index :as aws]
            [offcourse.adapters.embedly.index :as embedly]
            [offcourse.models.appstate.index :as model]
            [offcourse.core :as core]))

(defonce app (atom nil))
(defonce appstate (atom (model/new {:site-title "Offcourse_"})))
(defonce auth-config {:domain "yeehaa.eu.auth0.com"
                  :clientID "Z1J0CyMzZfIbOfBSVaMWJakoIrxm4Tfs"})

(def adapters
  [{:adapter           embedly/new-db
    :name              "embedly"
    :resources         #{:resources}
    :endpoint          "http://api.embed.ly/1/extract?key=5406650948f64aeb9102b9ea2cb0955c&urls="}
   {:adapter           aws/new-db
    :name              "courses-repo"
    :resources         #{:user-profile :course :collection}
    :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/development/query"}])

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app appstate adapters auth-config))
    (reset! app (component/start @app))))

(defn reload []
  (do
    (enable-console-print!)
    (reset! app (core/app appstate adapters auth-config))
    (reset! app (component/start @app))))

(defn stop []
  (component/stop @app))
