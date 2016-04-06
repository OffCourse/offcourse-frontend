(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def LambdaConstructor (.-Lambda js/AWS))

(defn- refresh-params [params token]
  (assoc params :Logins {"graph.facebook.com" token}))

(defn- refresh-credentials [{:keys [credentials]} token]
  (let [params (-> (.-params credentials)
                   js->clj
                   (refresh-params token))
        c (chan)]
    (set! (.-expired credentials) true)
    (set! (.-params credentials) (clj->js params))
    (.refresh credentials #(go (>! c true)))
    c))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [initial-config config] :as cloud} {:keys [token] :as query}]
  (go
    (if token
      (do
        (<! (refresh-credentials @config token))
        (.makeRequest (LambdaConstructor.) "invoke" (clj->js {:FunctionName "hello-world"}) #(println %2))
        (swap! config (fn [config] (assoc config :credentials (.. js/AWS.config -credentials)))))
      (do
        (.clearCachedId (:credentials @config))
        (let [credentials (CognitoConstructor. (clj->js initial-config))
              config (merge initial-config {:credentials credentials})]
          (.update js/AWS.config (clj->js config))
          (reset! (:config cloud) config))))
    (ri/respond cloud :refreshed-credentials :authenticated? (boolean token))))
