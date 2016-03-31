(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc menubar [{:keys [logo action-panel]}]
  [:.menubar
   [:.menubar--section logo]
   [:.menubar--section action-panel]])

