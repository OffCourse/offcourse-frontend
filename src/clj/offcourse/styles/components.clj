(ns offcourse.styles.components
  (:require [offcourse.styles.components.todo-list :refer [todo-list]]
            [offcourse.styles.components
             [collection-panel :refer [collection-panel collection-panels]]
             [resource-list :refer [resource-list]]
             [label :refer [label]]
             [card :refer [card]]
             [cards :refer [cards]]
             [viewer :refer [viewer]]
             [menubar :refer [menubar]]
             [dashboard :refer [dashboard]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [dashboard menubar navigation-panel card viewer label cards
                    todo-list collection-panels resource-list collection-panel]]
    (for [component components] (component config))))
