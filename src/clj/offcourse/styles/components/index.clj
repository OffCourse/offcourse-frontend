(ns offcourse.styles.components.index
  (:require [offcourse.styles.components
             [cards :refer [cards]]
             [dashboard :refer [dashboard]]
             [button :refer [button]]
             [strip :refer [strip]]
             [sheet :refer [sheet]]
             [label :refer [label-component]]
             [form :refer [form]]
             [list :refer [list-component]]
             [menubar :refer [menubar]]
             [viewer :refer [viewer]]]))

(defn navigation-panel [{:keys [templates units fonts colors]}]
  [[:.navigation-panel (merge (:component templates) {})]])

(defn components [config]
  (let [components [list-component sheet form strip
                    button dashboard menubar navigation-panel
                    viewer label-component cards]]
    (for [component components] (component config))))
