(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc menubar [{:keys [logo actions]}]
  [:.menubar
   [:.menubar--logo logo]
   [:menubar-actions
    [:nav
     [:ul
      (for [action actions]
        [:li.textbar {:key (action :yeehaa)}
         [:a {:href (action :yeehaa)} "+"]])]]]])
