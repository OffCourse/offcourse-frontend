(ns offcourse.styles.components.form
  (:require [offcourse.styles.vocabulary :as v]))

(defn form [{:keys [templates units]}]
  [[v/form (merge (:row-component templates)
                  {:justify-content :flex-end
                   :flex            1})
    [v/form--input (merge (:row-component templates)
                          {:text-align :right
                           :flex 7
                           :margin-right (:half units)})]]])
