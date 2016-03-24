(ns offcourse.views.components.actions-panel
  (:require [rum.core :as rum]
            [cuerdas.core :as str]))

(rum/defc actions-panel [actions]
  (when actions [:ul.actions-panel
    (keep (fn [[action-name action-url]]
            (when action-url
              [:li.textbar
               {:key [action-name]}
               [:a {:href action-url} (-> action-name
                                          name
                                          str/humanize
                                          str/titleize)]])) actions)]))
