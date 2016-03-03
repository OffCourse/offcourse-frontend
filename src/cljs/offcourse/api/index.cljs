(ns offcourse.api.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.api.queryable :as qa-impl]
            [com.stuartsierra.component :as lc]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema]))

(defn connect-to-repository [{:keys [adapter name fetchables supported-types]}]
  (lc/start (adapter name supported-types)))

(schema/defrecord API
    [component-name :- schema/Keyword
     repositories   :- [schema/Any]
     channels       :- {}
     actions        :- []
     reactions      :- {}
     fetchables     :- {}]
  Lifecycle
  (start [api] (ri/listen (update api :repositories #(map connect-to-repository %))))
  (stop [api] (ri/mute api))
  Queryable
  (-fetch [api query] (qa-impl/fetch api query))
  Responsive
  (-respond [api status payload] (ri/respond api status payload))
  (-respond [api status type result] (ri/respond api status type result))
  (-mute [api] (ri/mute api))
  (-listen  [api] (ri/listen api)))

(defn new [component-name]
  (map->API {:component-name component-name}))
