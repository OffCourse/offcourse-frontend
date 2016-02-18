(ns offcourse.ui.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.models.view :as view]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [rum.core :as rum]))

(defrecord UI [listener input-channel]
  Lifecycle
  (start [rd] (ri/listen rd))
  (stop [rd] (ri/mute rd))
  Renderable
  (-render [{:keys [views route-helpers handlers] :as rd} viewmodel]
    (let [view (view/new viewmodel route-helpers handlers views)]
      (rum/mount (rr/render view) (. js/document (getElementById "container")))
      (ri/respond rd :rendered-view)))
  Responsive
  (listen [rd] (assoc rd :listener (ri/-listen rd)))
  (mute [rd] (dissoc rd :listener))
  (respond [rd status] (ri/-respond rd status nil))
  (respond [rd status payload] (ri/-respond rd status payload)))

(defn new []
  (map->UI {:component-name :renderer}))
