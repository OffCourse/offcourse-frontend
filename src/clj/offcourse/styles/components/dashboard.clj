(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.helpers :as h]))

(defn dashboard [{:keys [templates colors units]}]
  (let [base-component (:component templates)
        subcomponents  [[:.dashboard              {:background-color (:day colors)}]
                        [:.dashboard--logo        {:padding (:full units)
                                                   :padding-bottom (:two units)
                                                   :background-color (:primary colors)
                                                   :flex-direction :row
                                                   :height         (:three units)}]
                        [:.dashboard--main {}]]]
    (h/augment-many base-component subcomponents)))

