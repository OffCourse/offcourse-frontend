(ns offcourse.api.index
  (:require [cljs.core.async :refer [<! >! put! close!]]
            [com.stuartsierra.component :as component]
            [offcourse.protocols.bootstrappable :as ba :refer [Bootstrappable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.api.implementations.bootstrappable :as ba-impl])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defrecord API [service output-channel input-channel]
  component/Lifecycle
  (start [api]
    (assoc api :listener (ba/bootstrap api)))
  (stop [api]
    (close! input-channel)
    (dissoc api :listener))
  Queryable
  (fetch [api query] (qa/fetch (:service api) query))
  Bootstrappable
  (bootstrap [api] (ba-impl/bootstrap api)))

(defn new-api []
  (map->API {}))
