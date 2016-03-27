(ns offcourse.styles.components.button
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden
             [arithmetic :refer [*]]
             [selectors :as s]]
            [offcourse.styles.modifiers :refer [removable selected hovered]]
            [offcourse.styles.classes :refer [btn list list--item]]))


(defn button [{:keys [templates colors units fonts]}]
  [btn {:flex         [[0 0 (:full units)]]
        :font-weight  700
        :margin-right (:full units)
        :font-size    (:one-and-half units)}
   [hovered (:highlighted templates)]])
