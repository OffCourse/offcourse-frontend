(ns offcourse.router.responsive
  (:require [offcourse.protocols.responsive :as ri]
            [pushy.core :as pushy]
            [bidi.bidi :as bidi]))

(defn handle-request [{:keys [reactions] :as rt} {:keys [handler route-params]}]
  (when-let [reaction ((handler reactions)
                       (assoc route-params
                              :checkpoint-id (int (:checkpoint-id route-params))))]
    (ri/respond rt :requested-route reaction)))

(defn listen [{:keys [routes] :as rt}]
  (assoc rt :listener (pushy/start! (pushy/pushy (partial handle-request rt)
                                                 (partial bidi/match-route routes)))))

(defn mute [{:keys [listener] :as rt}]
  (pushy/stop! listener)
  (dissoc rt :listener))

(defn respond [rt status payload] (ri/-respond rt status payload))
