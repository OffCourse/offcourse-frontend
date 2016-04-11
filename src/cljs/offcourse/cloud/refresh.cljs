(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            [AWS]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)

(defn credentials [{:keys [initial-config]} token]
  (new AWS.CognitoIdentityCredentials
       (clj->js
        {:IdentityPoolId (:IdentityPoolId initial-config)
         :expired true
         :Logins {"graph.facebook.com" token}})))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [initial-config] :as cloud} {:keys [token] :as query}]
  (set! (.. AWS -config -credentials) (credentials cloud token))
  (go
    (<! (qa/get cloud :credentials {}))
    (<! (qa/get cloud :dataset {}))
    (<! (qa/sync cloud))
    (ri/respond cloud :refreshed-credentials :authenticated? true)))
