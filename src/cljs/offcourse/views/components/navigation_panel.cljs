(ns offcourse.views.components.navigation-panel
  (:require [rum.core :as rum]))

(rum/defc button [[key action]]
  [:div.container--btn {:onClick action}
   [:button.btn (name key)]])

(rum/defc navigation-panel [actions]
  [:.navigation-panel
   (map (fn [[keyword :as action]]
          (rum/with-key (button action) keyword)) actions)])

