(ns offcourse.cloud.refresh
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def S3Constructor (.-S3 js/AWS))

(defn- refresh-params [params token]
  (if token
    (assoc params :Logins {"graph.facebook.com" token})
    (assoc params :Logins {})))

(defn- refresh-credentials [{:keys [credentials]} token]
  (let [params (-> (.-params credentials)
                   js->clj
                   (refresh-params token))
        instance (S3Constructor. (clj->js {:region "us-west-2"}))
        c (chan)]
    (set! (.-expired credentials) true)
    (set! (.-params credentials) (clj->js params))
    (.refresh credentials #(go (>! c true)))
    c))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :token [{:keys [config] :as cloud} {:keys [token] :as query}]
  (let [instance (S3Constructor. (clj->js {"region" "us-west-2"}))]
  (go
    (<! (refresh-credentials @config token))
    ;; check if token is expired
    #_ (.listObjects instance (clj->js {:Bucket "offcourse-staging"}) #(println %2))
    (swap! config (fn [config] (assoc config :credentials (.. js/AWS.config -credentials))))
    (ri/respond cloud :refreshed-credentials :authenticated? (boolean token)))))
