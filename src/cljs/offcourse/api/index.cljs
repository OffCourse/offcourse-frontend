(ns offcourse.api.index
  (:require [com.stuartsierra.component :as lc :refer [Lifecycle]]
            [offcourse.api.react :as react]
            [offcourse.api.send :as send]
            [shared.protocols.responsive :as ri :refer [Responsive]]))

(defrecord API []
  Lifecycle
  (start [api] (ri/listen api))
  (stop [api] (ri/mute api))
  Responsive
  (-respond [api event] (ri/respond api event))
  (-react [api event] (react/react api event))
  (-send [api event] (send/send api event))
  (-mute [api] (ri/mute api))
  (-listen [api] (ri/listen api)))

(defn create [name] (-> {:component-name name}
                        map->API))
