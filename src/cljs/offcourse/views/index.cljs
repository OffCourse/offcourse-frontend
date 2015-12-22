(ns offcourse.views.index
  (:require [cljs.core.async :refer [chan timeout put! <!]]
            [com.stuartsierra.component :as component]
            [offcourse.core :as core])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defonce counter (atom 0))

(defn listen [channel]
  (go-loop []
    (let [val (<! channel)]
      (swap! counter inc)
      (println "rerender:" @counter)
      (<! (timeout 1000))
      (core/render val))
    (recur)))

(defrecord View [listener input-channel]
  component/Lifecycle
  (start [api]
    (assoc api :listener (listen input-channel)))
  (stop [api]
    (close! input-channel)
    (dissoc api :listener)))

(defn new-renderer []
  (map->View {}))
