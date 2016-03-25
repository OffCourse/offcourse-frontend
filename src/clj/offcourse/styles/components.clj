(ns offcourse.styles.components
  (:refer-clojure :exclude [list])
  (:require [offcourse.styles.components
             [card :refer [card]]
             [cards :refer [cards]]
             [collection-panel :refer [collection-panel collection-panels]]
             [dashboard :refer [dashboard]]
             [label :refer [label]]
             [list :refer [list-component]]
             [menubar :refer [menubar]]
             [resource-list :refer [resource-list]]
             [viewer :refer [viewer]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [list-component dashboard menubar navigation-panel card viewer label cards
                    collection-panels resource-list collection-panel]]
    (for [component components] (component config))))
