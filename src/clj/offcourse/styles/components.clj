(ns offcourse.styles.components
  (:refer-clojure :exclude [list])
  (:require [offcourse.styles.components
             [card :refer [card]]
             [cards :refer [cards]]
             [collection-panel :refer [collection-panel collection-panels]]
             [dashboard :refer [dashboard]]
             [button :refer [button]]
             [label :refer [label-component]]
             [list :refer [list-component]]
             [menubar :refer [menubar]]
             [viewer :refer [viewer]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [list-component button dashboard menubar navigation-panel card viewer label-component cards collection-panels collection-panel]]
    (for [component components] (component config))))
