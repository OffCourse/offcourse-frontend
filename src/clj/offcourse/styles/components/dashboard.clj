(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.helpers :as h]))

(defn dashboard [{:keys [templates colors units]}]
  (let [base-component (:component templates)
        declarations   [[:.dashboard              {:background-color (:primary colors)
                                                   :padding          (:full units)}]
                        [:.dashboard__logo        {:padding-bottom (:full units)
                                                   :flex-direction :row
                                                   :height         (:two units)}]
                        [:.dashboard__collections {}]]]
    (h/augment-many base-component declarations)))

