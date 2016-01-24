(ns offcourse.protocols.rendering
  (:require [offcourse.protocols.responsive :as ri]
            [rum.core :as rum]))

(defprotocol Rendering
  (render [this component]))

(defn -render [{:keys [view-component] :as component} {:keys [viewmodel]}]
  (rum/mount (view-component viewmodel) (. js/document (getElementById "app")))
  (ri/respond component :rendered-view))
