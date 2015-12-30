(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<! close!]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn fetch [api query]
  (go
    {:type :fetched-data
     :payload (<! (qa/fetch (:service api) query))}))
