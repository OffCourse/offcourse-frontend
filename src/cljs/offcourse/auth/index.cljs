(ns offcourse.auth.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.auth.authenticatable :as ac-impl]
            [offcourse.auth.fetch :as fetch-impl]
            [offcourse.auth.get :as get-impl]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(schema/defrecord Auth
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Queryable
  (-check [auth query] (get-impl/get-status))
  (-get [auth query] (get-impl/get-profile))
  (-fetch [auth query] (fetch-impl/fetch auth query))
  Lifecycle
  (start [auth]
    (-> auth
        ac/init
        ri/listen
        ac/sign-in))
  (stop [auth] (ri/mute auth))
  Authenticable
  (-init [auth] (ac-impl/init auth))
  (-sign-in [auth] (ac-impl/sign-in auth))
  (-sign-out [auth] (ac-impl/sign-out auth))
  Responsive
  (-respond [auth status payload] (ri/respond auth status payload))
  (-respond [auth status type result] (ri/respond auth status type result))
  (-mute [auth] (ri/mute auth))
  (-listen [auth] (ri/listen auth)))

(defn new [] (map->Auth {:component-name :auth
                         :reactions {:requested-sign-in  ac/sign-in
                                     :requested-sign-out ac/sign-out}}))
