(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.models.action :as action])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defprotocol Responsive
  (-listen [this])
  (-mute [this])
  (-respond [this status] [this status payload] [this status type result]))

(def payloads
  {:collection-names    :collection-type
   :query               :missing-data
   :collection          :collection
   :courses             :courses
   :course              :course
   :add-checkpoint      :checkpoint
   :checkpoint          :checkpoint
   :view                :view-data
   :user                :user
   :state               :state
   :profile             :profile
   :authenticated?      :authenticated?
   :resources           :resources
   :resource            :resource})

(defn payload [type result]
  {:type type
   (type payloads) result})

(defn debug-helper [component-name status payload]
  (when #_true (= component-name :cloud)
    (println "--RESPONSE-----")
    (println "SENDER" component-name)
    (println "STATUS" status)
    #_(println "PAYLOAD" payload)))

(defn respond
  ([this status] (respond this status nil))
  ([{:keys [output-channel channels component-name]} status payload]
   (let [output-channel (or output-channel (:output channels))
         response       (action/new status component-name payload)]
     (debug-helper component-name status payload)
     (go
       (>! output-channel response))))
  ([this status type result](-respond this status (payload type result))))

(defn -listener [{:keys [channels component-name reactions] :as this}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! (:input channels))
          reaction (type reactions)]
      (when true #_(= component-name :cloud)
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
