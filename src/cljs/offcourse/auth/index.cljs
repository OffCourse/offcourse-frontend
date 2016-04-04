(ns offcourse.auth.index
  (:require [cljs.core.async :refer [<!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.auth.authenticatable :as ac-impl]
            [offcourse.auth.fetch :as fetch-impl]
            [offcourse.auth.get :as get-impl]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go]]))

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
    (ac/init auth)
    (go
      (let [{:keys [status authResponse]} (<! (qa/check auth {:type :status}))
            token (:accessToken authResponse)]
        (when (= status "connected")
          (ri/respond auth :signed-in-user {:type :token
                                            :token token}))
        (ri/listen auth))))
  (stop [auth] (ri/mute auth))
  Authenticable
  (-init [auth] (ac-impl/init auth))
  (-sign-in [auth] (ac-impl/sign-in auth))
  (-sign-out [auth] (ac-impl/sign-out auth))
  Responsive
  (-respond [auth status payload] (ri/respond auth status payload))
  (-respond [auth status type result] (ri/respond auth status type result))
  (-mute [auth] (ri/mute auth))
  (-listen  [auth] (ri/listen auth)))

(defn new [] (map->Auth {:component-name :auth}))
