(ns offcourse.user.authenticatable
  (:require [cljs.core.async :refer [<! chan close! >!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [FB]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))


(defn init-data []
  (.init js/FB (clj->js {:appId "1729934507285439"
                         :cookie     true
                         :xfbml      true
                         :version    "v2.5"})))

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
          user-name (keyword (get profile "name"))]
      (ri/respond user :refreshed-user :user {:name user-name}))))

(defn init [user]
  (init-data)
  (go
    (let [response (js->clj (<! (get-login-status)))
          status (keyword (get response "status"))]
      (refresh-user user))))

(defn sign-in [user]
  (.login js/FB #(refresh-user user)))

(defn sign-out [user]
  (.logout js/FB #(refresh-user user)))
