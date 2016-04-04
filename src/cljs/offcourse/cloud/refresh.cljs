(ns offcourse.cloud.refresh
  (:require cljsjs.aws-sdk-js))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))

(defn refresh
  ([{:keys [initial-config] :as cloud}]
   (let [credentials (CognitoConstructor. (clj->js initial-config))
         config (merge initial-config {:credentials credentials})]
     (.update js/AWS.config (clj->js config))
     (println (js->clj (.. js/AWS.config -credentials -params) :keywordize-keys true))
     (reset! (:config cloud) config)))
  ([{:keys [config] :as cloud} query]
   (.update js/AWS.config (clj->js @config))
   (reset! (:config cloud) js/AWS.config)))
