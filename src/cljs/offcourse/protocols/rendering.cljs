(ns offcourse.protocols.rendering
  (:require [offcourse.protocols.responsive :as ri]
            [rum.core :as rum]
            [cljs.pprint :as pp]))

(defprotocol Rendering
  (render [this component]))

(defn -render [component {:keys [data view-component] :as pl}]
  (rum/mount (view-component data) (. js/document (getElementById "container")))
  (ri/respond component :rendered-view))
