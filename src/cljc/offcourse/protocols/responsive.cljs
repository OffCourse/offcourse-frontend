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

(extend-protocol Responsive
  object
  (respond
    ([api status]
     (respond api status nil))
    ([{:keys [output-channel component-name]} status payload]
     (if output-channel
       (go (>! output-channel (new-action status payload)))
       (new-action status payload)))
    ([api status type result]
     (respond api status (payload type result))))
  (listen [{:keys [output-channel component-name input-channel actions] :as this}]
    (let [first-run (atom true)]
      (go-loop []
        (when @first-run
          (let [initial-response-type (keyword (str (name component-name) "-initialized"))]
            (respond this initial-response-type this)
            (swap! first-run not)
            (<! (timeout 1000))))
        (let [{:keys [type payload]} (<! input-channel)
              action                 (type actions)]
          (println type)
          (when action
            (action this payload)))
        (recur)))))
