(ns offcourse.api.index
  (:require [com.stuartsierra.component :as lc :refer [Lifecycle]]
            [offcourse.api.queryable :as qa-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema]))

(defn connect-to-repository [{:keys [adapter] :as config}]
  (lc/start (adapter (select-keys config [:name :endpoint :resources]))))

(schema/defrecord API
    [component-name :- schema/Keyword
     repositories   :- [schema/Any]
     channels       :- {}
     reactions      :- {}]
  Lifecycle
  (start [api]
    (-> api
        (update :repositories #(map connect-to-repository %))
        ri/listen))
  (stop [api] (ri/mute api))
  Queryable
  (-fetch [api {:keys [payload]}] (qa-impl/fetch api payload))
  Responsive
  (-respond [api status payload] (ri/respond api status payload))
  (-respond [api status type result] (ri/respond api status type result))
  (-mute [api] (ri/mute api))
  (-listen [api] (ri/listen api)))

(defn new []
  (map->API {:component-name :api
             :reactions {:not-found-data qa/fetch
                         :refreshed-auth-token qa/fetch}}))
