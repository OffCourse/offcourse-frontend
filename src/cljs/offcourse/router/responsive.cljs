(ns offcourse.router.responsive
  (:require [bidi.bidi :as bidi]
            [offcourse.protocols.responsive :as ri]
            [pushy.core :as pushy]))

(defn handle-request [{:keys [responses history] :as rt} {:keys [handler route-params]}]
  (ri/respond rt :requested-view ((handler responses) route-params)))

(defn restart [{:keys [history] :as rt}]
  (pushy/replace-token! history "/"))

(defn listen [{:keys [routes responses] :as rt}]
  (let [history (pushy/pushy (partial handle-request rt)
                             (partial bidi/match-route routes))
        rt (assoc rt :history history)]
    (pushy/start! history)
    (ri/listen rt)))

(defn mute [{:keys [history listeners] :as rt}]
  (pushy/stop! history)
  (dissoc rt :listeners))

(defn respond [rt status payload] (ri/-respond rt status payload))
