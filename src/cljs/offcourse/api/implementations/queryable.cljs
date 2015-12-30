(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<! >! put! timeout]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn fetch [{:keys [service] :as api} query]
  (go
    (ri/respond api :fetched-data (<! (qa/fetch service query)))))
