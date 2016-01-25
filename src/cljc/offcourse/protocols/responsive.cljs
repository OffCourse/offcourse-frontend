(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! put! timeout]]
            [offcourse.models.action :as action])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defprotocol Responsive
  (listen [this])
  (mute [this])
  (respond [this status] [this status payload] [this status type result]))

(defn payload [type result]
  {:type type
   type result})

(defn first-run [{:keys [component-name actions reactions initialized?] :as component}]
  (when-not @initialized?
    (let [initial-response-type (keyword (str "initialized-" (name component-name)))
          responses actions
          actions (keys reactions)]
      (respond component initial-response-type {:responses responses
                                                :actions actions})
      (swap! initialized? not))))

(def counter (atom 1))

(defn -respond
  ([{:keys [output-channel log-channel component-name]} status payload]
   (swap! counter inc)
   (if (and output-channel (> 100 @counter))
     (go
       (>! output-channel (action/new status component-name payload))
       (when log-channel (>! log-channel (action/new status component-name payload))))
     (action/new status component-name payload)))
  ([this status type result](-respond this status (payload type result))))

(defn -listen [{:keys [input-channel reactions initialized?] :as this}]
  (go-loop []
    (first-run this)
    (let [{:keys [type source payload] :as action} (<! input-channel)
          reaction (type reactions)]
      (when reaction
        (reaction this payload))
      (recur))))
