(ns offcourse.cloud.reset
  (:require [AWS]
            [offcourse.protocols.responsive :as ri]))

(def AWS js/AWS)

(defn credentials [{:keys [initial-config]}]
  (new AWS.CognitoIdentityCredentials
       (clj->js
        {:IdentityPoolId (:IdentityPoolId initial-config)})))

(defn reset [cloud]
  (set! (.. AWS -config -credentials) (credentials cloud))
  (set! (.. AWS -config) (clj->js {"region" "eu-west-1"}))
  (ri/respond cloud :refreshed-credentials :authenticated? false))
