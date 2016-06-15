(ns offcourse.ui.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [medley.core :as medley]
            [offcourse.models.view :as view]
            [offcourse.protocols.composable :as ca]
            [offcourse.protocols.mountable :as ma]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema]))

(schema/defrecord UI
    [component-name :- schema/Keyword
     channels       :- {}
     url-helpers    :- {}
     handlers       :- {}
     views          :- {}
     viewmodels     :- {}
     reactions      :- {}]
  Lifecycle
  (start [rd] (ri/listen rd))
  (stop [rd] (ri/mute rd))
  Renderable
  (-render [{:keys [views url-helpers components handlers] :as rd}
            {:keys [payload] :as query}]
    (let [responder (partial ri/respond rd)
          handlers (medley/map-vals #(% responder) handlers)
          view     (view/new (:state payload) components url-helpers handlers)]
      (-> view
          (ca/compose views)
          (rr/render)
          (ma/mount "#container"))
    (ri/respond rd :rendered-view)))

  Responsive
  (-listen [rd] (ri/listen rd))
  (-mute [rd] (dissoc rd :listener))
  (-respond [rd status] (ri/respond rd status nil))
  (-respond [rd status payload] (ri/respond rd status payload)))

(defn new []
  (map->UI {:component-name :ui
            :reactions {:refreshed-state rr/render}}))
