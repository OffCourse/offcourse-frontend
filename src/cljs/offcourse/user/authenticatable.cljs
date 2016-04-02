(ns offcourse.user.authenticatable
  (:require [cljs.core.async :refer [<! chan close! >!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [FB]
            [cuerdas.core :as str]
            [schema.core :as schema]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def S3Constructor (.-S3 js/AWS))

(defn init-aws [identity-config]
  (let [region (get identity-config "region")
        identity-pool-id (select-keys identity-config ["IdentityPoolId"])
        credentials (CognitoConstructor. (clj->js identity-pool-id))
        config (clj->js {"region" region
                         "credentials" credentials})]
    (.update js/AWS.config config)
    (.listObjects (S3Constructor.) (clj->js {"Bucket" "offcourse-staging"}) #(println %2))))

(defn init-data [config]
  (.init js/FB (clj->js config)))

(defn get-status []
  (let [c (chan)]
    (.getLoginStatus js/FB #(go (>! c %)))
    c))

(defn get-profile []
  (let [c (chan)]
    (.api js/FB "/me" #(go (>! c %)))
    c))

(defn init [{:keys [auth-config identity-config] :as user}]
  (init-aws identity-config)
  (init-data auth-config)
  (go
    (let [response (js->clj (<! (get-status)))
          status (keyword (get response "status"))]
      (case status
        :connected (let [profile (js->clj (<! (get-profile)))]
                     (qa/refresh user profile))
        (qa/refresh user nil)))))

(defn sign-in [user]
  (go
    (let [profile (js->clj (<! (get-profile)))]
      (.login js/FB #(qa/refresh user profile)))))

(defn sign-out [user]
  (.logout js/FB #(qa/refresh user nil)))
