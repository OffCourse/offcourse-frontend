(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]
            [clojure.string :as str]))


(rum/defc menubar [{:keys [logo action-panel]}]
  [:.menubar
   [:.menubar--logo logo]
   [:menubar-actions
    [:nav action-panel]]])
