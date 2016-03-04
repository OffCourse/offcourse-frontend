(ns offcourse.router.responsive
  (:require [offcourse.protocols.responsive :as ri]
            [offcourse.models.collection :as cl]
            [pushy.core :as pushy]
            [bidi.bidi :as bidi]))

(defn cl-dummy [collection] {:view-type :collection-view
                             :view-data    {:type       :collection
                                            :collection collection}})

(defn cp-dummy [{:keys [checkpoint-id] :as data}]
  {:view-type :checkpoint-view
   :view-data {:type :course
               :course (select-keys data [:curator :hashtag])
               :checkpoint (or (int checkpoint-id) 0)}})

(def rr
  {:home-view       (fn [] (cl-dummy (cl/new :flags :featured)))
   :new-course-view (fn [data] data)
   :collection-view (fn [data] (cl-dummy data))
   :checkpoint-view (fn [data] (cp-dummy data))})

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
