(ns offcourse.ui.index
  (:require [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [rum.core :as rum]
            [com.stuartsierra.component :refer [Lifecycle]]))

(defrecord UI [listener input-channel]
  Lifecycle
  (start [rd] (ri/listen rd))
  (stop [rd] (ri/mute rd))
  Renderable
  (-render [{:keys [views routes] :as rd} {:keys [view-name] :as viewmodel}]
    (let [view (view-name views)]
      (rum/mount (view viewmodel routes) (. js/document (getElementById "container")))
      (ri/respond rd :rendered-view)))
  Responsive
  (listen [rd] (assoc rd :listener (ri/-listen rd)))
  (mute [rd] (dissoc rd :listener))
  (respond [rd status] (ri/-respond rd status nil))
  (respond [rd status payload] (ri/-respond rd status payload)))

(defn new []
  (map->UI {:component-name :renderer}))
