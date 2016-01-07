(ns offcourse.api.index
  (:require [cljs.core.async :refer [close!]]
            [com.stuartsierra.component :as component]
            [offcourse.protocols.bootstrappable :as ba :refer [Bootstrappable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.api.implementations.bootstrappable :as ba-impl]
            [offcourse.api.implementations.queryable :as qa-impl]))

(defrecord API [name courses-service output-channel input-channel actions]
  component/Lifecycle
  (start [api] (assoc api :listener (ba/bootstrap api)))
  (stop [api]
    (do
      (close! input-channel)
      (dissoc api :listener)))
  Queryable
  (fetch [api query] (qa-impl/fetch api query))
  Bootstrappable
  (bootstrap [api] (ba-impl/-bootstrap api)))

(defn new-api []
  (map->API {:name "api-service"}))
