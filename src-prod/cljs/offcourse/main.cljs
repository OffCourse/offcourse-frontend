(ns offcourse.main
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.aws.index :as aws]
<<<<<<< HEAD
            [offcourse.adapters.embedly.index :as embedly]
=======
>>>>>>> 48199ef... clean up main files
            [offcourse.core :as core]
            [offcourse.adapters.fakedb.index :as fakedb]))

(set! cljs.core/*print-fn* identity)

(defonce app (atom nil))

<<<<<<< HEAD
(def auth-config {:domain "yeehaa.eu.auth0.com"
                  :clientID "Z1J0CyMzZfIbOfBSVaMWJakoIrxm4Tfs"})
=======
(def auth-config {"appId" "1729964960615727"
                  "cookie"     true
                  "xfbml"      true
                  "version"    "v2.5"})
>>>>>>> 48199ef... clean up main files

(def identity-config {:region "eu-west-1"
                      :IdentityPoolId "eu-west-1:a2cc5db6-028e-412c-953e-11658f0b1eb5"})

(def adapters
<<<<<<< HEAD
  [{:adapter           embedly/new-db
    :name              "embedly"
    :resources         #{:resources}
    :endpoint          "http://api.embed.ly/1/extract?key=5406650948f64aeb9102b9ea2cb0955c&urls="}
   {:adapter           aws/new-db
    :name              "courses-repo"
    :resources         #{:user-profile :course :collection}
    :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/v1/query"}])

=======
  [#_{:adapter           fakedb/new-db}
   {:adapter           aws/new-db
    :name              "aws"
    :endpoint          "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/v1/query"}])
>>>>>>> 48199ef... clean up main files

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app adapters auth-config identity-config))
    (reset! app (component/start @app))))
