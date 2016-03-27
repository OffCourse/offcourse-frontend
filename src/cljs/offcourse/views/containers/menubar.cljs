(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc menubar [{:keys [logo action-panel sign-in-panel]}]
  [:.menubar
   [:.menubar--logo logo]
   [:.menubar--actions action-panel sign-in-panel]])

