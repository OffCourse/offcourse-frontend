(ns offcourse.cloud.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.cloud.refresh :as refresh-impl]
            [offcourse.cloud.reset :as reset-impl]
            [offcourse.cloud.sync :as sync-impl]
            [offcourse.cloud.get :as get-impl]
            [cljs.core.async :refer [<! chan >!]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go]]))


(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Lifecycle
  (start [cloud]
    (qa/reset cloud)
    (ri/listen cloud))
  (stop [cloud] (ri/mute cloud))
  Queryable
  (-get [cloud query] (get-impl/get cloud query))
  (-refresh [cloud query] (refresh-impl/refresh cloud query))
  (-reset [cloud] (reset-impl/reset cloud))
  (-sync [cloud] (sync-impl/sync cloud))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->Cloud {:component-name :cloud
                          :profile-data (atom nil)}))
