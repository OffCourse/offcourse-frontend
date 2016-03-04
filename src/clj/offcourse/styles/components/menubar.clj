(ns offcourse.styles.components.menubar
  (:require [offcourse.styles.helpers :as h]
            [garden
             [units :as u :refer [px percent]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(defn menubar [{:keys [templates colors units]}]
  (let [base-component (:component templates)
        subcomponents  [[:.menubar              {:background-color (:primary colors)
                                                 :display :flex
                                                 :height :auto
                                                 :flex-direction :row
                                                 :justify-content :space-between
                                                 :padding (:full units)}]]]
    [(h/augment-many base-component subcomponents)]))

