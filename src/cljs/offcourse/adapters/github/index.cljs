(ns offcourse.adapters.github.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.adapters.github.send :as send-impl]
            [shared.protocols.responsive :as ri :refer [Responsive]]))

(defrecord Github []
  Lifecycle
  (start [db] db)
  (stop  [db] db)
  Responsive
  (-send [db event] (send-impl/send db event)))

(defn new-db [config]
  (map->Github config))
