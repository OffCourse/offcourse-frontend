(ns offcourse.styles.components.label
  (:require [offcourse.styles
             [classes :as c]
             [modifiers :as m]]))

(defn label-component [{:keys [templates fonts colors units]}]
  [c/labels  (merge (:row-component templates)
                    {:flex-wrap :wrap})
   [c/label (merge (:column-component templates)
                   (:tiny-font templates)
                   (:recycled-paper templates)
                   {:height       (:full units)
                    :flex-direction :column
                    :margin-bottom    (:sixth units)
                    :margin-right     (:sixth units)
                    :align-items      :center
                    :justify-content  :center
                    :padding          [[(:tenth units) (:half units)]]})
   [m/selected (:selected templates)]
   [m/hovered (:highlighted templates)]]])
