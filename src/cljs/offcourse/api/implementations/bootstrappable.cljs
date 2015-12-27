(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >!]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.bootstrappable :as ba :refer [Bootstrappable]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn listen [{:keys [output-channel input-channel] :as api}]
  (go-loop []
    (let [{:keys [type payload]} (<! input-channel)]
      (case type
        :not-found-data (>! output-channel (<! (qa/fetch api payload))))
      (recur))))

(defn bootstrap [{:keys [output-channel input-channel status service] :as api}]
  (go
    (let [{:keys [error] :as response} (<! (ba/bootstrap service))]
      (>! output-channel {:status response})
      (if error
        (>! output-channel {:error response})
        (listen api)))))
