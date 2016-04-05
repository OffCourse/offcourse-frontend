(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))
(def LambdaConstructor (.-Lambda js/AWS))

(defn- refresh-credentials [credentials token]
  (let [c (chan)
        params (-> (.-params credentials)
                   js->clj
                   (assoc :Logins {"graph.facebook.com" token}))]
    (set! (.-expired credentials) true)
    (set! (.-params credentials) (clj->js params))
    (.refresh credentials #(go (>! c true)))
    c))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [config] :as cloud} {:keys [token]}]
  (let [instance (LambdaConstructor.)]
    (if token
      (go
        (<! (refresh-credentials (:credentials @config) token))
        (.invoke instance (clj->js {:FunctionName "hello-world"
                                    :Payload (.stringify js/JSON (clj->js {:message "HELLO WORLD"}))}) #(println %2)))
      (do
        (.clearCachedId (:credentials @config))
        (qa/refresh cloud {:type :initialize})))
    (ri/respond cloud :refreshed-credentials :authenticated? (boolean token))))

(defmethod refresh :initialize [{:keys [initial-config] :as cloud}]
  (let [credentials (CognitoConstructor. (clj->js initial-config))
        config (merge initial-config {:credentials credentials})]
    (.update js/AWS.config (clj->js config))
    (reset! (:config cloud) config)))
