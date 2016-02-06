(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! close! >!]]
            [offcourse.models.action :as action])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defprotocol Responsive
  (listen [this])
  (mute [this])
  (respond [this status] [this status payload] [this status type result]))

(defn payload [type result]
  {:type type
   type result})

(def counter (atom 1))

(defn -respond
  ([{:keys [output-channel log-channel channels component-name]} status payload]
   (let [output-channel (or output-channel (:output channels))
         log-channel (or log-channel (:log channels))]
     (swap! counter inc)
     (if (and output-channel (> 100 @counter))
       (go
         (>! output-channel (action/new status component-name payload))
         (when log-channel (>! log-channel (action/new status component-name payload))))
       (action/new status component-name payload))))
  ([this status type result](-respond this status (payload type result))))

(defn -listen [{:keys [channels reactions] :as this}]
  (assoc this :listener
         (go-loop []
           (let [{:keys [type source payload] :as action} (<! (:input channels))
                 reaction (type reactions)]
             (when reaction
               (reaction this payload))
             (recur)))))


(defn -mute [{:keys [channels] :as this}]
  (close! (:input channels))
  (-> this
      (dissoc :listener)))
