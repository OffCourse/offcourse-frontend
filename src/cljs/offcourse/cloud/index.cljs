(ns offcourse.cloud.index
  (:require cljsjs.aws-sdk-js
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.cloud.refresh :as refresh-impl]
            [schema.core :as schema]))

(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Queryable
  (-refresh [cloud]
    (refresh-impl/refresh cloud)
    (println @(:config cloud)))
  (-refresh [cloud query]
    (refresh-impl/refresh cloud query)
    (println @(:config cloud)))
  Lifecycle
  (start [cloud] (qa/refresh cloud))
  (stop [cloud] nil))

(defn new [] (map->Cloud {:component-name :cloud
                          :config (atom {})}))

