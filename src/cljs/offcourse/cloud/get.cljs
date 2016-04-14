(ns offcourse.cloud.get
  (:refer-clojure :exclude [get])
  (:require [cljs.core.async :refer [<! chan >!]]
            [AWS]
            [medley.core :as medley]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)

(defn parse-json [payload]
  (->> payload
       (.parse js/JSON)
       js->clj
       (medley/map-kv (fn [key value][(keyword key)(keyword value)]))))

(defn get-profile [profile-data]
  (let [c (chan)]
    (.get profile-data "profile" #(go (if %2
                                        (>! c %2)
                                        (>! c false))))
    c))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :credentials [cloud query]
  (let [c (chan)]
    (.get (.. AWS.config -credentials) #(go (>! c true)))
    c))

(defmethod get :dataset [cloud query]
  (let [c (chan)]
    (.openOrCreateDataset (AWS.CognitoSyncManager.)
                          "profile-data"
                          #(go
                             (reset! (:profile-data cloud) %2)
                             (>! c %2)))
    c))

(defmethod get :profile [{:keys [profile-data] :as cloud} query]
  (go
    (if-let [profile (<! (get-profile @profile-data))]
      (do
        (qa/sync cloud)
        (ri/respond cloud :found-profile {:type :user
                                          :user (parse-json profile)}))
      (ri/respond cloud :not-found-profile {:type :profile}))))
