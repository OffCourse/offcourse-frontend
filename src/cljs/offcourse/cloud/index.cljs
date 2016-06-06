(ns offcourse.cloud.index
  (:require [cljs.core.async :refer [<!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.cloud.add :as add-impl]
            [offcourse.cloud.get :as get-impl]
            [offcourse.cloud.queryable :as qa-impl]
            [offcourse.cloud.refresh :as refresh-impl]
            [offcourse.cloud.reset :as reset-impl]
            [offcourse.cloud.sync :as sync-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Lifecycle
  (start [cloud]
    (go
      (qa/reset cloud)
      (<! (qa/get cloud {:type :dataset}))
      (ri/listen cloud)))
  (stop [cloud] (ri/mute cloud))
  Queryable
  (-get [cloud query] (get-impl/get cloud query))
  (-add [cloud query] (add-impl/add cloud query))
  (-refresh [cloud query] (refresh-impl/refresh cloud query))
  (-fetch [cloud query] (qa-impl/fetch cloud query))
  (-reset [cloud] (reset-impl/reset cloud))
  (-sync [cloud] (sync-impl/sync cloud))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->Cloud {:component-name :cloud
                          :profile-data (atom nil)}))
