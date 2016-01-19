(ns offcourse.api.lifecycle
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.protocols.bootstrappable :as ba]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn start [{:keys [service] :as api}]
  (go
    (let [response  (<! (ba/bootstrap service))
          ready?    (= (:type response) :db-ready)]
      (if ready?
        (assoc api :listener (ri/listen api))
        (ri/respond api :api-error response)))))

(defn stop [{:keys [input-channel] :as api}]
  (do
    (close! input-channel)
    (dissoc api :listener)))
