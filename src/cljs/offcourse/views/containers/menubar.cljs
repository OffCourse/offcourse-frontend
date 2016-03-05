(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc action-panel [actions]
  [:ul
   (for [[key action] actions]
     [:li.textbar {:key key}
      [:a {:href "#"
           :on-click #(action)} "+"]])])

(rum/defc menubar [{:keys [logo actions]}]
  [:.menubar
   [:.menubar--logo logo]
   [:menubar-actions
    [:nav
     (action-panel actions)]]])
