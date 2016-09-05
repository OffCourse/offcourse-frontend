(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc menubar [logo actions-panel]
  [:.menubar
   [:.menubar--section logo]
   [:.menubar--section actions-panel]])
