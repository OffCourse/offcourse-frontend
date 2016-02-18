(ns offcourse.views.components.navigation-panel
  (:require [rum.core :as rum]
            [offcourse.views.components.button :refer [button]]))

(rum/defc navigation-panel [handlers]
  [:.navigation-panel
   (map (fn [[keyword :as handler]]
          (rum/with-key (button handler) keyword)) handlers)])
