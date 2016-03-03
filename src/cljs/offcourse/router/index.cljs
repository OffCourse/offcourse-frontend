(ns offcourse.router.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.router.responsive :as ri-impl]
            [schema.core :as schema]))

(schema/defrecord Router
    [component-name :- schema/Keyword
     routes         :- []
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [rt] (ri/-listen rt))
  (stop [rt] (ri/mute rt))
  Responsive
  (-listen [rt] (ri-impl/listen rt))
  (-mute [rt] (ri-impl/mute rt))
  (-respond [rt status payload] (ri-impl/respond rt status payload)))

(defn new []
  (map->Router {:component-name :router}))
