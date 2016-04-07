(ns offcourse.cloud.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.cloud.refresh :as refresh-impl]
            [offcourse.cloud.fetch :as fetch-impl]
            cljsjs.aws-sdk-js
            [schema.core :as schema]))

(defn invoke-lambda [function-name payload]
  (.makeRequest (AWS.Lambda.) "invoke"
                (clj->js {:FunctionName function-name
                          :Payload (.stringify js/JSON (clj->js payload))})
                #(println %2)))

(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Lifecycle
  (start [cloud]
    (qa/refresh cloud :init {})
    (ri/listen cloud))
  (stop [cloud] (ri/mute cloud))
  Queryable
  (-refresh [cloud query] (refresh-impl/refresh cloud query))
  (-fetch [cloud query] (fetch-impl/fetch cloud query))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->Cloud {:component-name :cloud}))
