(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.aws.index :as aws]
            [offcourse.core :as core]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defonce app (atom nil))

(def auth-config {"appId" "1730376537241236"
                  "cookie"     true
                  "xfbml"      true
                  "version"    "v2.5"})

(def identity-config {:region "eu-west-1"
                      :IdentityPoolId "eu-west-1:c897bdeb-03e7-449a-ac28-f00c6876dbd8"})


(def adapters
  [#_{:adapter           fakedb/new-db}
  {:adapter           aws/new-db
   :name              "aws"
   :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/development/query"}])

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app adapters auth-config identity-config))
    (reset! app (component/start @app))))

(defn reload []
  (do
    (enable-console-print!)))

(defn stop []
  (component/stop @app))
