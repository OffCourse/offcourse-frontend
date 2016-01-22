(ns offcourse.router.index
  (:require [cljs.core.async :refer [put!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.sample-route-requests :refer [sample-request]]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]))

(def actions [:requested-route])

(def routes ["/tags/agile" :home-view])

(defn payload [handler collection-type collection-name]
  (handler {:home-view       {:type            :collection-view
                              :collection-type :flags
                              :collection-name :featured}
            :collection-view {:type            :collection-view
                              :collection-type collection-type
                              :collection-name  collection-name}}))

(defn request [handler params]
  {:type :requested-route
   :payload (apply payload handler params)})

(defn handle-request [rt {:keys [handler route-params] :as req}]
  (let [reaction (apply request handler (vec route-params))]
    (when reaction
      (ri/respond rt (:type reaction) (:payload reaction)))))

(defn listen [rt]
  (assoc rt :listener (ri/listen rt)))

(defrecord Router [component-name output-channel actions]
  Lifecycle
  (start [{:keys [routes] :as rt}] (listen rt))
  (stop [{:keys [listener] :as rt}]
    (pushy/stop! listener)
    (dissoc rt :listener))
  Responsive
  (listen [rt] (pushy/start! (pushy/pushy (partial handle-request rt)
                                          (partial bidi/match-route routes))))
  (respond [rt status payload] (ri/-respond rt status payload)))

(defn new []
  (map->Router {:component-name :router
                :routes routes
                :actions actions}))
