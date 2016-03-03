(ns offcourse.router.responsive
  (:require [offcourse.protocols.responsive :as ri]
            [offcourse.models.collection :as cl]
            [offcourse.viewmodels.checkpoint-view.index :as cpvm]
            [offcourse.viewmodels.collection-view.index :as clvm]
            [pushy.core :as pushy]
            [bidi.bidi :as bidi]))
(def rr
  {:home-view       (fn [] {:view-type :collection-view
                            :view-data {:type :collection
                                        :collection (cl/new :flags :featured)}})
   :collection-view (fn [data] (clvm/dummy data))
   :checkpoint-view (fn [data] (cpvm/dummy data))})

(defn handle-request [rt {:keys [handler route-params]}]
  (ri/respond rt :requested-route {:type :appstate
                                   :appstate ((handler rr) route-params)}))

(defn restart [{:keys [history] :as rt}]
  (pushy/replace-token! history "/"))

(defn listen [{:keys [routes] :as rt}]
  (let [history (pushy/pushy (partial handle-request rt)
                             (partial bidi/match-route routes))
        rt (assoc rt :history history)]
    (pushy/start! history)
    (ri/listen rt)))


(defn mute [{:keys [history listeners] :as rt}]
  (pushy/stop! history)
  (dissoc rt :listeners))

(defn respond [rt status payload] (ri/-respond rt status payload))
