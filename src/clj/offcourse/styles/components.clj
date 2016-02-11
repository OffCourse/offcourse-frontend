(ns offcourse.styles.components
  (:require [offcourse.styles.components.todo-list :refer [todo-list]]
            [offcourse.styles.components
             [collection-panel :refer [collection-panel]]
             [card :refer [card cards]]
             [dashboard :refer [dashboard]]]))

(defn components [config]
  (let [components [dashboard card cards todo-list collection-panel]]
    (for [component components] (component config))))
