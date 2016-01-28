(ns offcourse.protocols.rendering
  (:require [offcourse.protocols.responsive :as ri]
            [rum.core :as rum]))

(defprotocol Rendering
  (render [this component]))

(defn -render [{:keys [view-component] :as component} payload]
  (rum/mount (view-component payload) (. js/document (getElementById "app")))
  (ri/respond component :rendered-view))
