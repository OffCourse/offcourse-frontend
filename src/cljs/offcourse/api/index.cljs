(ns offcourse.api.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.api.lifecycle :as lc-impl]
            [offcourse.api.queryable :as qa-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]))

(def actions   [:failed-fetch :fetched-data])

(def reactions {:not-found-data qa/fetch})

(defrecord API [component-name courses-service output-channel input-channel reactions initialized?]
  Lifecycle
  (start [api] (lc-impl/start api))
  (stop [api] (lc-impl/stop api))
  Queryable
  (fetch [api query] (qa-impl/fetch api query))
  Responsive
  (respond [api status payload] (ri/-respond api status payload))
  (respond [api status type result] (ri/-respond api status type result))
  (listen  [api] (ri/-listen api)))

(defn new []
  (map->API {:component-name :api-service
             :reactions reactions
             :actions actions
             :initialized? (atom false)}))
