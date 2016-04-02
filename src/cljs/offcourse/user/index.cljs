(ns offcourse.user.index
  (:require cljsjs.aws-sdk-js
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.user.authenticatable :as ac-impl]
            [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [cuerdas.core :as str])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn refresh [user profile]
  (go
    (if-let [user-name (keyword (str/slugify (get profile "name")))]
      (ri/respond user :refreshed-user :user {:name user-name})
      (ri/respond user :refreshed-user :user {:name nil}))))

(schema/defrecord User
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Queryable
  (-refresh [user query] (refresh user query))
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
