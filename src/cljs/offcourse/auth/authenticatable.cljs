(ns offcourse.auth.authenticatable
  (:require [cljs.core.async :refer [<! >! chan]]
            [FB]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init [{:keys [auth-config identity-config] :as auth}]
  (.init js/FB (clj->js auth-config)))

(defn -sign-in []
  (let [c (chan)]
    (.login js/FB (fn [response]
                    (go (>! c (js->clj response :keywordize-keys true)))))
    c))

(defn -sign-out []
  (let [c (chan)]
    (.logout js/FB #(go (>! c %)))
    c))

(defn sign-in [auth]
  (go
    (let [{:keys [status authResponse] :as res} (<! (-sign-in))
          token (:accessToken authResponse)]
      (when (= status "connected")
        (ri/respond auth :signed-in-user {:type :token
                                          :token token}))
      #_(qa/fetch auth :profile response))))

(defn sign-out [auth]
  (go
    (let [response (<! (-sign-out))]
      (ri/respond auth :signed-out-user {}))))
