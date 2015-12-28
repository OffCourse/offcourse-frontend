(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >! timeout]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.bootstrappable :as ba :refer [Bootstrappable]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(def responses {:not-found-data qa/fetch})

(defn listen [{:keys [output-channel input-channel] :as this}]
  (go-loop []
    (let [{:keys [type payload]} (<! input-channel)
          response ((type responses) this payload)]
      (>! output-channel (<! response))
      (recur))))

(defn bootstrap [{:keys [output-channel input-channel status service] :as api}]
  (go
    (let [{:keys [error] :as response} (<! (ba/bootstrap service))]
      (>! output-channel {:status response})
      (<! (timeout 1000))
      (if error
        (>! output-channel {:error response})
        (listen api)))))
