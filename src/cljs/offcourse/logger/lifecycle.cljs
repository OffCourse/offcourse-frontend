(ns offcourse.logger.lifecycle
  (:require [cljs.core.async :refer [close!]]
            [offcourse.protocols.responsive :as ri]))

(defn start [component]
  (let [component (assoc component :log (atom ()))]
    (assoc component :listener (ri/listen component))))

(defn stop [{:keys [channels] :as component}]
  (close! (:input channels))
  (-> component
      (dissoc :listener)))
