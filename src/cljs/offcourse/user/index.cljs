(ns offcourse.user.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [schema.core :as schema]))

(schema/defrecord User
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [user] (ri/listen user))
  (stop [user] (ri/mute user))
  Authenticable
  (-authenticate [user query] (ri/respond user :signed-in-user query))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->User {:component-name :user}))