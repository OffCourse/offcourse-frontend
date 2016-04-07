(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)
(def region "eu-west-1")

(defn new-credentials [{:keys [initial-config]}]
  (new AWS.CognitoIdentityCredentials
       (clj->js
        {:IdentityPoolId (:IdentityPoolId initial-config)})))

(defn credentials [{:keys [initial-config]} token]
  (new AWS.CognitoIdentityCredentials
       (clj->js
        {:IdentityPoolId (:IdentityPoolId initial-config)
         :expired true
         :Logins {"graph.facebook.com" token}})))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [initial-config] :as cloud} {:keys [token] :as query}]
  (if token
    (do
      (set! (.. AWS -config -region) "eu-west-1")
      (set! (.. AWS -config -credentials) (credentials cloud token))
      (.makeRequest (AWS.Lambda.) "invoke" (clj->js {:FunctionName "hello-world"}) #(println %2)))
    (set! (.. AWS -config -credentials) (new-credentials cloud)))
  (ri/respond cloud :refreshed-credentials :authenticated? (boolean token)))

(defmethod refresh :init [{:keys [initial-config config] :as cloud}]
  (set! (.. AWS -config) (clj->js {"region" "eu-west-1"}))
  (set! (.. AWS -config -credentials) (new-credentials cloud))
  (ri/respond cloud :refreshed-credentials :authenticated? false))
