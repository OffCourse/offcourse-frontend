(ns offcourse.views.components.logo
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc logo [routes]
  (let [home-route (path-for routes :home-view :collection-name :featured)]
    [:.logo
     [:a.logo.textbar {:href home-route} "Offcourse_"]]))
