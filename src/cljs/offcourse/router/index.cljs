(ns offcourse.router.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.router.responsive :as ri-impl]
            [offcourse.router.refresh :as refresh-impl]
            [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Router
    [component-name :- schema/Keyword
     routes         :- []
     responses      :- {}
     channels       :- {}
     actions        :- []
     reactions      :- {}]
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
  (map->Router {:component-name :router}))
