(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! put! timeout]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defrecord Action [type payload])

(defn new-action [type payload]
  (->Action type payload))

(defprotocol Responsive
  (listen [this])
  (respond [this status] [this status payload] [this status type result]))

(defn payload [type result]
  {:type type
   type result})

(defn first-run? [{:keys [component-name actions reactions initialized?] :as component}]
  (when-not @initialized?
    (let [initial-response-type (keyword (str "initialized-" (name component-name)))]
      (println "----------")
      (println "initialized:      " (name component-name))
      (println "can respond to:   " (keys reactions))
      (println "will respond with:" actions)
      (println "----------")
      (respond component initial-response-type component)
      (swap! initialized? not))))

(defn -respond
  ([{:keys [output-channel component-name]} status payload]
   (if output-channel
     (go (>! output-channel (new-action status payload)))
     (new-action status payload)))
  ([this status type result](-respond this status (payload type result))))

(defn -listen [{:keys [output-channel component-name input-channel reactions initialized?]
                :as this}]
  (go-loop []
    (first-run? this)
    (let [{:keys [type payload]} (<! input-channel)
          reaction                 (type reactions)]
      (when reaction
        (reaction this payload)))
    (recur)))
