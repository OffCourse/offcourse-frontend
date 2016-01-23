(ns offcourse.router.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.router.responsive :as ri-impl]))

(defrecord Router [component-name output-channel actions]
  Lifecycle
  (start [rt] (ri/listen rt))
  (stop [rt] (ri/mute rt))
  Responsive
  (listen [rt] (ri-impl/listen rt))
  (mute [rt] (ri-impl/mute rt))
  (respond [rt status payload] (ri-impl/respond rt status payload)))

(defn new [routes actions reactions]
  (map->Router {:component-name :router
                :routes routes
                :actions actions
                :reactions reactions}))
