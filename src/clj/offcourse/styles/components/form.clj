(ns offcourse.styles.components.form
  (:require [offcourse.styles.vocabulary :as v]))

(defn form [{:keys [templates colors units]}]
  [[v/form (merge (:row-component templates)
                  {:justify-content :flex-end
                   :flex            1})
    [v/title {:color (:medium colors)}]
    [v/form--input (merge (:row-component templates)
                          {:text-align :right
                           :flex 7
                           :height (:one-and-half units)
                           :margin-right (:sixth units)
                           :padding   [[(:tenth units) (:half units)]]
                           :font-size (:tag-font units)
                           :align-items :center})]]])
