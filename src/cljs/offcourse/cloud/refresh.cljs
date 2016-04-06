(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def LambdaConstructor (.-Lambda js/AWS))

(defn -refresh-credentials [credentials]
  (let [c (chan)]
    (.refresh credentials #(go (>! c true)))
    c))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [initial-config config] :as cloud} {:keys [token] :as query}]
  (go
    (if token
      (do
        (.clearCachedId (.. @config -credentials))
        (let [config (merge initial-config (:Logins {:graph.facebook.com token}))
              credentials (CognitoConstructor. (clj->js config))
              config (merge initial-config {:credentials credentials
                                            :expired true})]
          (.update js/AWS.config (clj->js config))
          (.makeRequest (LambdaConstructor.) "invoke"
                        (clj->js {:FunctionName "hello-world"})
                        #(println %1))
          (reset! (:config cloud) js/AWS.config)))
      (do
        (.clearCachedId (.. @config -credentials))
        (let [credentials (CognitoConstructor. (clj->js initial-config))
              config (merge initial-config {:credentials credentials})]
          (.update js/AWS.config (clj->js config))
          (reset! (:config cloud) js/AWS.config))))
    (ri/respond cloud :refreshed-credentials :authenticated? (boolean token))))
