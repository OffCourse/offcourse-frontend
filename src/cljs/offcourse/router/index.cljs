(ns offcourse.router.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.router.refresh :as refresh-impl]
            [offcourse.router.responsive :as ri-impl]))

(defrecord Router []
  Lifecycle
  (start [rt] (ri/-listen rt))
  (stop [rt] (ri/mute rt))
  Queryable
  (-refresh [rt query] (refresh-impl/refresh rt query))
  Responsive
  (-listen [rt] (ri-impl/listen rt))
  (-mute [rt] (ri-impl/mute rt))
  (-respond [rt status payload] (ri-impl/respond rt status payload)))

(defn new []
  (map->Router {:component-name :router
                :reactions {:refreshed-state qa/refresh}}))
