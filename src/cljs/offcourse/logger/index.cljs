(ns offcourse.logger.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defonce log (atom ()))

(defn listen [{:keys [input-channel initialized?] :as this}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! input-channel)]
      (swap! log #(conj % [(.getTime (js/Date.)) type source (when payload payload)]))
      (ri/respond this :updated-logs {:log (take 100 @log)})
      (recur))))

(defrecord Logger [component-name input-channel output-channel
                   actions reactions initialized?]
  Lifecycle
  (start [lg] (ri/listen lg))
  (stop [lg] lg)
  Responsive
  (respond [lg status payload] (ri/-respond lg status payload))
  (listen [lg] (assoc lg :listener (listen lg))))

(defn new [actions reactions]
  (map->Logger {:component-name :logger
                :actions actions
                :initialized? (atom false)}))
