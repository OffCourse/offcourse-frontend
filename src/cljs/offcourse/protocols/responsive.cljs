(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! close! >!]]
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
   :course-view         :dependencies
   :new-course-view     :dependencies
   :collection-view     :dependencies
   :checkpoint-view     :dependencies
   :add-checkpoint      :checkpoint
   :checkpoint          :checkpoint
   :view                :view-data
   :user                :user
   :profile             :profile
   :resources           :resources
   :resource            :resource})

(defn payload [type result]
  {:type type
   (type payloads) result})

(def counter (atom 0))

(defn debug-helper [component-name status payload]
  (when (= component-name :auth)
    (println "--RESPONSE-----")
    (println "SENDER" component-name)
    (println "STATUS" status)
    (println "PAYLOAD" payload)))

(defn respond
  ([this status] (respond this status nil))
  ([{:keys [output-channel log-channel channels component-name]} status payload]
   (let [output-channel (or output-channel (:output channels))
         log-channel    (or log-channel (:log channels))
         response       (action/new status component-name payload)]
     #_(debug-helper component-name status payload)
     (go
       (swap! counter inc)
       (>! output-channel response)
       (when log-channel (>! log-channel response)))))
  ([this status type result](-respond this status (payload type result))))

(defn -listener [{:keys [channels component-name reactions] :as this}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! (:input channels))
          reaction (type reactions)]
      (when #_true (= component-name :user)
        #_(debug-helper source type payload))
      (when reaction
        (if (= reaction :forward)
          (respond this type payload)
        (reaction this payload)))
      (recur))))

(defn listen [{:keys [channels component-name reactions] :as this}]
  (assoc this :listener (-listener this)))

(defn mute [{:keys [channels] :as this}]
  (close! (:input channels))
  (-> this
      (dissoc :listener)))
