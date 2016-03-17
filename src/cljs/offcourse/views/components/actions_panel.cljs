(ns offcourse.views.components.actions-panel
  (:require [rum.core :as rum]))

(rum/defc actions-panel [actions]
  [:ul.actions-panel
   (keep (fn [[action-name action-url]]
           (when action-url
             [:li.textbar
              {:key [action-name]}
              [:a {:href action-url} (name action-name)]])) actions)])
