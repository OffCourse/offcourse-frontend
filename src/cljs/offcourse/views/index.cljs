(ns offcourse.views.index
  (:require [cljs.core.async :refer [chan close! <!]]
            [com.stuartsierra.component :as component]
            [offcourse.views.debug :as debug])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defonce counter (atom 0))

(defn render [response]
  (debug/render response))

(defn listen [channel]
  (go-loop []
    (let [val (<! channel)]
      (swap! counter inc)
      (println "rerender:" @counter)
      (render val))
    (recur)))

(defrecord Renderer [listener input-channel]
  component/Lifecycle
  (start [api]
    (assoc api :listener (listen input-channel)))
  (stop [api]
    (close! input-channel)
    (dissoc api :listener)))

(defn new-renderer []
  (map->Renderer {}))
