(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >! timeout]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.bootstrappable :as ba])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn bootstrap [{:keys [service] :as api}]
  (go
    (if-let [error (:error (<! (ba/bootstrap service)))]
      (ri/respond api :api-error error)
      (ri/listen api))))
