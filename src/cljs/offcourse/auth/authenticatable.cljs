(ns offcourse.auth.authenticatable
  (:require [cljs.core.async :refer [<! >! chan]]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn -sign-in [provider]
  (let [c (chan)]
    (.show provider (fn [error response token]
                      (go (>! c {:error error
                                 :response response
                                 :token token}))))
    c))

(defn -sign-out []
  (.removeItem js/localStorage "auth-token"))

(defn sign-in [{:keys [config provider] :as auth}]
  (go
    (let [{:keys [token]} (<! (-sign-in provider))]
      (.setItem js/localStorage "auth-token" token)
      (ri/respond auth :fetched-auth-token :auth-token token))))

(defn sign-out [auth]
  (go
    (-sign-out)
    (ri/respond auth :removed-auth-token :auth-token nil)))
