(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >! timeout]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.bootstrappable :as ba])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn bootstrap [{:keys [output-channel input-channel status service] :as api}]
  (go
    (let [{:keys [error] :as response} (<! (ba/bootstrap service))]
      (if error
        (>! output-channel {:type :api-error
                            :payload response}))
        (do
          (ri/respond api)
          (>! output-channel {:type :api-ready
                              :payload response})))))
