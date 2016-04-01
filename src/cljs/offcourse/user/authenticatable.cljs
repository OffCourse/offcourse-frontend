(ns offcourse.user.authenticatable
  (:require [cljs.core.async :refer [<! chan close! >!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [FB]
            [cuerdas.core :as str]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))


(defn init-data [config]
  (.init js/FB (clj->js config)))

(defn get-login-status []
  (let [c (chan)]
    (.getLoginStatus js/FB #(go (>! c %)))
    c))

(defn get-profile []
  (let [c (chan)]
    (.api js/FB "/me" #(go (>! c %)))
    c))

(defn refresh-user [user]
  (go
    (let [profile (js->clj (<! (get-profile)))
          user-name (keyword (str/slugify (get profile "name")))]
      (ri/respond user :refreshed-user :user {:name user-name}))))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def S3Constructor (.-S3 js/AWS))
(def ConfigConstructor (.-Config js/AWS))

(defn init [{:keys [auth-config identity-config] :as user}]

  (let [credentials (CognitoConstructor.
                      "{\"IdentityPoolId\": \"eu-west-1:8ec6381f-02fc-4167-a272-2dd785d8aee2\"}")]
    (println credentials)
    (init-data auth-config)
    (go
      (let [response (js->clj (<! (get-login-status)))
            status (keyword (get response "status"))]
        (refresh-user user)))))

(defn sign-in [user]
  (.login js/FB #(refresh-user user)))

(defn sign-out [user]
  (.logout js/FB #(refresh-user user)))
