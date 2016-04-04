(ns offcourse.auth.authenticatable
  (:require [cljs.core.async :refer [<! >! chan]]
            [FB]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn init [{:keys [auth-config identity-config] :as auth}]
  (.init js/FB (clj->js auth-config)))

(defn -sign-in []
  (let [c (chan)]
    (.login js/FB #(go (>! c %)))
    c))

(defn -sign-out []
  (let [c (chan)]
    (.logout js/FB #(go (>! c %)))
    c))

(defn sign-in [auth]
  (go
    (let [response (<! (-sign-in))]
      (qa/fetch auth :profile {}))))

(defn sign-out [auth]
  (go
    (let [response (<! (-sign-out))]
      (qa/fetch auth :profile {}))))
