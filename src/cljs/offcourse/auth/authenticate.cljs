(ns offcourse.auth.authenticate
  (:require [cljs.core.async :as async :refer [<! >! chan]]
            [shared.protocols.responsive :as ri]
            [shared.protocols.validatable :as va])
  (:require-macros [cljs.core.async.macros :refer [go]]))


(defn -sign-in [provider]
  (let [c (chan)]
    (.show provider (fn [error response token]
                      (async/put! c {:error error
                                     :response response
                                     :token token})))
    c))

(defn -sign-out [] (.removeItem js/localStorage "auth-token"))

(defmulti react (fn [_ event] (va/resolve-payload event)))

(defmethod react [:requested :sign-in] [{:keys [config provider] :as auth} _]
  (go
    (let [{:keys [token]} (<! (-sign-in provider))]
      (.setItem js/localStorage "auth-token" token)
      (ri/respond auth [:granted {:auth-token token}]))))

(defmethod react [:requested :sign-out] [auth _]
  (go
    (-sign-out)
    (ri/respond auth [:revoked {:auth-token nil}])))
