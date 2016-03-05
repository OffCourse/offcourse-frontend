(ns offcourse.user.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema]))

(schema/defrecord User
    [component-name :- schema/Keyword
     repositories   :- [schema/Any]
     channels       :- {}
     actions        :- []
     reactions      :- {}
     fetchables     :- {}]
  Lifecycle
  (start [user] (ri/listen user))
  (stop [user] (ri/mute user))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new []
  (map->User {:component-name :user}))
