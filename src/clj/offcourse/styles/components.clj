(ns offcourse.styles.components
  (:require [offcourse.styles.components.dashboard :refer [dashboard]]
            [offcourse.styles.components.collection-panel :refer [collection-panel]]))

(defn components [config]
  (let [components [dashboard collection-panel]]
    (for [component components] (component config))))
