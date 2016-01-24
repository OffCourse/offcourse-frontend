(ns offcourse.renderer.index
  (:require [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.rendering :as rr :refer [Rendering]]
            [com.stuartsierra.component :refer [Lifecycle]]))

(defrecord Renderer [listener input-channel]
  Lifecycle
  (start [rd] (ri/listen rd))
  (stop [rd] (ri/mute rd))
  Rendering
  (render [rd res] (rr/-render rd res))
  Responsive
  (listen [rd] (assoc rd :listener (ri/-listen rd)))
  (mute [rd] (dissoc rd :listener))
  (respond [rd status] (ri/-respond rd status nil))
  (respond [rd status payload] (ri/-respond rd status payload)))

(defn new [actions reactions view-component]
  (map->Renderer {:component-name :renderer
                  :actions actions
                  :reactions reactions
                  :view-component view-component
                  :initialized? (atom false)}))
