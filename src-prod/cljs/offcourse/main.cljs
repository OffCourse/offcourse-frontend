(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.aws.index :as aws]
            [offcourse.core :as core]
            [offcourse.adapters.fakedb.index :as fakedb]))

(set! cljs.core/*print-fn* identity)

(defonce app (atom nil))

(def auth-config {"appId" "1729964960615727"
                  "cookie"     true
                  "xfbml"      true
                  "version"    "v2.5"})

(def identity-config {:region "eu-west-1"
                      :IdentityPoolId "eu-west-1:a2cc5db6-028e-412c-953e-11658f0b1eb5"})

(def adapters
  [#_{:adapter           fakedb/new-db}
   {:adapter           aws/new-db
    :name              "aws"
    :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/v1/query"}])

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app adapters auth-config identity-config))
    (reset! app (component/start @app))))
