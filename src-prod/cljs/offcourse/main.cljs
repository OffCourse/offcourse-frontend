(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.aws.index :as aws]
            [offcourse.adapters.github.index :as github]
            [offcourse.core :as core]
            [shared.models.appstate.index :as model]))

(set! cljs.core/*print-fn* identity)

(defonce appstate (atom (model/new {:site-title "Offcourse_"})))

(defonce app (atom nil))

(defonce auth-config {:domain "yeehaa.eu.auth0.com"
                      :clientID "Z1J0CyMzZfIbOfBSVaMWJakoIrxm4Tfs"})

(def adapters
  [{:adapter           github/new-db
    :name              "bootstrap"
    :repo-name         "sample-content"
    :organization      "offcourse"
    :sha               "04871f3539e3ac197a04f5904823eff705691521"
    :resources         #{:course :collection}
    :endpoint          "https://api.github.com"}
   {:adapter           aws/new-db
    :name              "courses-repo"
    :resources         #{:user-profile :course :collection}
    :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/v1/query"}])

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app appstate adapters auth-config))
    (reset! app (component/start @app))))
