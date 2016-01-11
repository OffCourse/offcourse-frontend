(ns offcourse.api.index
  (:require [cljs.core.async :refer [close!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.bootstrappable :as ba :refer [Bootstrappable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.api.implementations.bootstrappable :as ba-impl]
            [offcourse.api.implementations.queryable :as qa-impl]))

(def actions   [:failed-fetch :fetched-data])

(def reactions {:not-found-data qa/fetch})

(defrecord API [component-name courses-service output-channel input-channel reactions initialized?]
  Lifecycle
  (start [api]
    (assoc api :listener (ba/bootstrap api)))
  (stop [api]
    (do
      (close! input-channel)
      (dissoc api :listener)))
  Queryable
  (fetch [api query] (qa-impl/fetch api query))
  Bootstrappable
  (bootstrap [api] (ba-impl/-bootstrap api))
  Responsive
  (respond [api status payload] (ri/-respond api status payload))
  (respond [api status type result] (ri/-respond api status type result))
  (listen  [api] (ri/-listen api)))

(defn new-api []
  (map->API {:component-name :api-service
             :reactions reactions
             :actions actions
             :initialized? (atom false)}))
