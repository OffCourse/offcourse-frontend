(ns offcourse.logger.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.logger.responsive :as ri-impl]
            [schema.core :as schema]))

(schema/defrecord Logger
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [component] (ri/listen (assoc component :log (atom ()))))
  (stop [component]  (ri/mute component))
  Responsive
  (-listen [component] (ri-impl/listen component))
  (-mute [component] (ri/mute component))
  (-respond [component status payload] (ri/respond component status payload)))

(defn new []
  (map->Logger {:component-name :logger}))
