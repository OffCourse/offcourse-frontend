(ns offcourse.router.index
  (:require [cljs.core.async :refer [put!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.sample-route-requests :refer [sample-request]]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]))

(def actions [:requested-route])

(def app-routes ["/" {"foo" :foo
                      "bar" :bar}])

(defrecord Router [component-name output-channel actions]
  Lifecycle
  (start [rt]
    (pushy/start! (pushy/pushy #(put! output-channel
                                      (when (= (:handler %) :foo)
                                        sample-request))
                               (partial bidi/match-route app-routes)))
    rt)
  (stop [rt]
    rt)
  Responsive
  (respond [rt status payload] (ri/-respond rt status payload)))

(defn new []
  (map->Router {:component-name :router
                :actions actions}))
