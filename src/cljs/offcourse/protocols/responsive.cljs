(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.models.action :as action]
            [offcourse.specs.action :as specs]
            [cljs.spec :as spec]
            [offcourse.models.payload.index :as payload :refer [Payload]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defprotocol Responsive
  (-listen [this])
  (-mute [this])
  (-respond [this status] [this status payload] [this status type result]))

(defn debug-helper [component-name status payload]
  (when true #_(= component-name :appstate)
    (println "--RESPONSE-----")
    (println "SENDER" component-name)
    (println "STATUS" status)
    (println "PAYLOAD" payload)))

(defn respond
  ([this status] (respond this status nil))
  ([{:keys [output-channel channels component-name] :as this} status payload]
   (let [output-channel (or output-channel (:output channels))
         response       (action/new this status payload)]
     #_(if-not (spec/valid? ::specs/action response)
       (println response)
       (println (spec/explain ::specs/action response)))
     (go
       (>! output-channel response))))
  ([this status type result]
   (-respond this status (payload/new type result))))


(defn -listener [{:keys [channels component-name reactions] :as this}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! (:input channels))
          reaction (type reactions)]
      (when #_true (= component-name :ui)
            #_(when (= type :authenticated-user) (println reaction))
            #_(debug-helper source type payload))
      (when reaction
        (reaction this action))
      (recur))))

(defn listen [{:keys [channels component-name reactions] :as this}]
  (assoc this :listener (-listener this)))

(defn mute [{:keys [channels] :as this}]
  (close! (:input channels))
  (-> this
      (dissoc :listener)))
