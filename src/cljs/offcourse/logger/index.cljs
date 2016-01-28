(ns offcourse.logger.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.logger.responsive :as ri-impl]
            [offcourse.logger.lifecycle :as lc-impl]
            [schema.core :as schema]))

(schema/defrecord Logger
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [component] (lc-impl/start component))
  (stop [component]  (lc-impl/stop component))
  Responsive
  (listen [component] (ri-impl/listen component))
  (respond [component status payload] (ri/-respond component status payload)))

(defn new []
  (map->Logger {:component-name :logger}))
