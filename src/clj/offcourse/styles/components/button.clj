(ns offcourse.styles.components.button
  (:require [offcourse.styles.vocabulary :as v]))

(defn button [{:keys [templates colors units fonts]}]

  [[v/textbar-button (merge (:textbar templates)
                            {:font-size (:subtitle-font units)
                             :margin-right (:sixth units)})
    [v/hovered (merge (:paper templates))]
    [v/disabled {:background-color (:medium colors)
                 :color (:day colors)}]]

   [v/icon-button {:font-size        (:full units)
                   :font-weight      700
                   :display :flex
                   :justify-content :center
                   :align-items     :center
                   :height           (:one-and-half units)
                   :width           (:one-and-half units)
                   :margin-right     0
                   :color  (:day colors)
                   :background-color (:night colors)}
    [v/hovered {:background-color (:primary colors)}]]

   [v/checkbox-button (merge (:component templates)
                             (:paper templates)
                             {:display          :flex
                              :margin-right     (:two-third units)
                              :width            (:two-third units)
                              :height           (:two-third units)})
    [v/selected {:background-color (:primary colors)
                 :border [[(:fifteenth units) :solid (:day colors)]]}]]

   [v/understated-button {:color       (:medium colors)
                          :user-select :none}
     [v/hovered {:color (:primary colors)}]]])
