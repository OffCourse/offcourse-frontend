(ns offcourse.styles.components.label
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [selectors :as s]]
            [offcourse.styles.modifiers :refer [hovered selected]]
            [offcourse.styles.classes :refer [label]]))

(defn label-component [{:keys [templates fonts colors units]}]
  [[label {:display          :inline-flex
           :height           (:full units)
           :margin-right     (:sixth units)
           :margin-bottom    (:sixth units)
           :font-size        (:tag-font units)
           :align-items      :center
           :font-family      (:base fonts)
           :font-weight      300
           :justify-content  :center
           :padding          [[0 (:half units)]]
           :color            (:night colors)
           :background-color (:light colors)}
    [selected (:selected templates)]
    [hovered (:highlighted templates)]]])
