(ns offcourse.user.index
  (:require [cljs.core.async :refer [<! >! chan]]
            cljsjs.aws-sdk-js
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.user.refresh :as refresh-impl]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.user.authenticatable :as ac-impl]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def S3Constructor (.-S3 js/AWS))

(defn get-profile []
  (let [c (chan)]
    (.api js/FB "/me" #(go (>! c (js->clj % :keywordize-keys true))))
    c))

(defn init-aws
  ([{:keys [identity-config]}]
  (let [region (get identity-config "region")
        identity-pool-id (select-keys identity-config ["IdentityPoolId"])
        credentials (CognitoConstructor. (clj->js identity-pool-id))
        config (clj->js {"region" region
                         "credentials" credentials})]
    (.update js/AWS.config config)
    (println (js->clj (.. js/AWS.config -credentials -params) :keywordize-keys true))))
  ([{:keys [identity-config]} auth-token]
   (let [region (get identity-config "region")
         identity-pool-id (select-keys identity-config ["IdentityPoolId"])
         credentials (CognitoConstructor. (clj->js identity-pool-id))
         config (clj->js {"region" region
                          "credentials" credentials})]
     (.update js/AWS.config config)
     (println (js->clj (.. js/AWS.config -credentials -params) :keywordize-keys true)))))

(schema/defrecord User
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Queryable
  (-refresh [user query] (refresh-impl/refresh user query))
  Lifecycle
  (start [user]
    (go
      (let [{:keys [status authResponse]} (<! (ac/init user))
            auth-token (:accessToken authResponse)
            profile (<! (get-profile))]
        (if auth-token
          (init-aws user auth-token)
          (init-aws user))
        (when (= status "connected")
          (qa/refresh user :profile profile))
        (ri/listen user))))
  (stop [user] (ri/mute user))
  Authenticable
  (-init [user] (ac-impl/init user))
  (-sign-in [user] (ac-impl/sign-in user))
  (-sign-out [user] (ac-impl/sign-out user))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->User {:component-name :user}))
