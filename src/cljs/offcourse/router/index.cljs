(ns offcourse.router.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [shared.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.router.react :as react-impl]
            [offcourse.router.responsive :as ri-impl]))

(defrecord Router []
  Lifecycle
  (start [rt] (ri/-listen rt))
  (stop [rt] (ri/mute rt))
  Responsive
  (-listen [rt] (ri-impl/listen rt))
  (-react [rt event] (react-impl/react rt event))
  (-mute [rt] (ri-impl/mute rt))
  (-respond [rt event] nil))

(defn create [name] (-> {:component-name name}
                        map->Router))
