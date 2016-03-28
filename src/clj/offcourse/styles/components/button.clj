(ns offcourse.styles.components.button
  (:require [offcourse.styles.vocabulary :as v]))

(defn button [{:keys [templates colors units fonts]}]

  [[v/textbar-button (:textbar templates)
    [v/hovered (merge (:highlighted templates)
                      {:color (:day colors)})]
    [v/disabled {:background-color (:medium colors)
                 :color (:light colors)}
     [v/hovered {:background-color (:medium colors)
                 :color (:day colors)}]]]

   [v/icon-button {:font-size        (:full units)
                   :font-weight      700
                   :justify-content :flex-end
                   :margin-right     0
                   :background-color (:day colors)}

    [v/hovered {:color (:primary colors)}]]

   [v/checkbox-button (merge (:component templates)
                             (:paper templates)
                             {:display          :flex
                              :margin-right     (:two-third units)
                              :width            (:two-third units)
                              :height           (:two-third units)})]

   [v/understated-button {:color       (:medium colors)
                          :user-select :none}
     [v/hovered {:color (:primary colors)}]]])
