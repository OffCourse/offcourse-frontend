(ns offcourse.ui.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [shared.protocols.renderable :as rr :refer [Renderable]]
            [shared.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.ui.render :as render-impl]))

(defrecord UI []
  Lifecycle
  (start [rd] (ri/listen rd))
  (stop [rd] (ri/mute rd))
  Renderable
  (-render [rd query] (render-impl/render rd query))
  Responsive
  (-listen [rd] (ri/listen rd))
  (-react [rd event] (rr/render rd event))
  (-mute [rd] (dissoc rd :listener))
  (-respond [rd event] (ri/respond rd event)))

(defn create [name] (-> {:component-name name
                         :container "#container"}
                        map->UI))
