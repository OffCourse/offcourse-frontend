(ns offcourse.auth.authenticatable
  (:require [cljs.core.async :refer [<! >! chan]]
            [cljsjs.auth0]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init [{:keys [config] :as auth}]
  (assoc auth :provider (js/Auth0. (clj->js config))))

(defn -sign-in [provider]
  (let [c (chan)]
    (.login provider
            (clj->js {:popup true
                      :connection "github"})
            (fn [error response]
              (go (>! c response))))
    c))

(defn -sign-out []
  (println "signing out...")
  #_(let [c (chan)]
    (.logout js/FB #(go (>! c %)))
    c))

(defn sign-in [{:keys [config provider] :as auth}]
  (go
    (let [res (<! (-sign-in provider))]
      (println res)
      #_(when (= status "connected")
        (ri/respond auth :signed-in-user {:type :token
                                          :token token})))))

(defn sign-out [auth]
  (go
    (let [response (<! (-sign-out))]
      (ri/respond auth :signed-out-user {:type :token
                                         :token nil}))))
