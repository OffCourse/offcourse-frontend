(ns offcourse.user.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.user.refresh :as refresh-impl]
            [schema.core :as schema]))

(schema/defrecord User
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Queryable
  (-refresh [user query] (refresh-impl/refresh user query))
  Lifecycle
  (start [user] (ri/listen user))
  (stop [user] (ri/mute user))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->User {:component-name :user}))
