(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! put! timeout]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defrecord Action [type payload])

(defn new-action [type payload]
  (->Action type payload))

(defprotocol Responsive
  (listen [this])
  (respond [this type payload]))

(extend-protocol Responsive
  object
  (respond [{:keys [output-channel]} type payload]
    (go (>! output-channel (new-action type payload))))
  (listen [{:keys [output-channel name input-channel actions] :as this}]
    (let [first-run (atom true)]
      (go-loop []
        (when @first-run
          (let [initial-response-type (keyword (str name "-initialized"))]
            (respond this initial-response-type this)
            (swap! first-run not)
            (<! (timeout 1000))))
        (let [{:keys [type payload]} (<! input-channel)
              action (type actions)]
              (action this payload))
          (recur)))))
