(ns offcourse.user.index
  (:require [cljs.core.async :refer [<! chan close! >!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.user.authenticatable :as ac-impl]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(schema/defrecord User
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [user]
    (go
      (ac/init user)
      (ri/listen user)))
  (stop [user] (ri/mute user))
  Authenticable
  (-init [user] (ac-impl/init user))
  (-sign-in [user] (ac-impl/sign-in user))
  (-sign-out [user] (ac-impl/sign-out user))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->User {:component-name :user}))
