(ns offcourse.views.index
  (:require [cljs.core.async :refer [chan timeout close! <!]]
            [com.stuartsierra.component :as component]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.views.debug :as debug])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defonce counter (atom 0))

(defn render [response]
  (debug/render response))

(defn listen [{:keys [component-name output-channel input-channel actions] :as this}]
  (go-loop []
    (let [{:keys [type payload] :as val} (<! input-channel)]
      (swap! counter inc)
      #_(println "rerender:" @counter)
      (render val)
      (<! (timeout 1000)))
    (recur)))

(defrecord Renderer [listener input-channel]
  component/Lifecycle
  (start [api]
    (assoc api :listener (ri/listen api)))
  (stop [api]
    (close! input-channel)
    (dissoc api :listener))
  Responsive
  (listen [api] (listen api)))

(defn new-renderer []
  (map->Renderer {:component-name :renderer}))
