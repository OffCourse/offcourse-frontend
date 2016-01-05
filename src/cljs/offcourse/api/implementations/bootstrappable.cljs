(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >! timeout]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.bootstrappable :as ba])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn bootstrap [{:keys [service] :as api}]
  (go
    (let [{:keys [type] :as response} (<! (ba/bootstrap service))]
      (if (or (= type :db-ready) (= type :db-bootstrapped))
        (ri/listen api)
        (ri/respond api :api-error response)))))
