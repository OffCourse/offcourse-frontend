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

(defn get-status []
  (let [c (chan)]
    (.getLoginStatus js/FB #(go (>! c (js->clj % :keywordize-keys true))))
    c))

(defn get-profile []
  (let [c (chan)]
    (.api js/FB "/me" #(go (>! c (js->clj % :keywordize-keys true))))
    c))

(defn init [{:keys [auth-config identity-config] :as user}]
  (go
    (.init js/FB (clj->js auth-config))
    (let [response (<! (get-status))]
      response)))

(defn sign-in [user]
  (.login js/FB #(go (qa/refresh user :profile (<! (get-profile))))))

(defn sign-out [user]
  (.logout js/FB #(qa/refresh user nil)))
