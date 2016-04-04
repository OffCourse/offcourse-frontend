(ns offcourse.user.index
  (:require [cljs.core.async :refer [<! >! chan]]
            cljsjs.aws-sdk-js
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.user.refresh :as refresh-impl]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def S3Constructor (.-S3 js/AWS))

(defn init-aws
  ([{:keys [identity-config]}]
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
    (init-aws user)
    (ri/listen user))
  (stop [user] (ri/mute user))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->User {:component-name :user}))
