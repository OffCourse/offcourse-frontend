(ns offcourse.views.components.navigation-panel
  (:require [rum.core :as rum]))

(rum/defc navigation-panel []
  [:.navigation-panel
   [:button "Learn"]
   [:button "Edit"]])
