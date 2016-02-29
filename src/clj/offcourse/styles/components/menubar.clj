(ns offcourse.styles.components.menubar
  (:require [offcourse.styles.helpers :as h]
            [garden
             [units :as u :refer [px percent]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(defn menubar [{:keys [templates colors units]}]
  (let [base-component (:component templates)
        subcomponents  [[:.menubar              {:background-color (:day colors)
                                                 :display :flex
                                                 :height :auto
                                                 :flex-direction :column
                                                 :justify-content :center}]
                        [:.menubar--logo        {:padding (:full units)
                                                 :background-color (:primary colors)}]]]
    [(h/augment-many base-component subcomponents)]))


