(ns offcourse.styles.components.label
  (:require [offcourse.styles.vocabulary :as v]))

(defn label-component [{:keys [templates fonts colors units]}]
  [v/labels  (merge (:row-component templates)
                    {:flex-wrap :wrap})
   [v/label (merge (:column-component templates)
                   (:tiny-font templates)
                   (:recycled-paper templates)
                   {:height       (:full units)
                    :flex-direction :column
                    :margin-bottom    (:sixth units)
                    :margin-right     (:sixth units)
                    :align-items      :center
                    :justify-content  :center
                    :padding          [[(:tenth units) (:half units)]]})
   [v/selected (:highlighted templates)]
   [v/hovered (:selected templates)]]])
