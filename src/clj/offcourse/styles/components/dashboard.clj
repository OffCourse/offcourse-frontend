(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.helpers :as h]
            [garden
             [units :as u :refer [px percent]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(defn dashboard [{:keys [templates colors units]}]
  (let [base-component (:component templates)
        subcomponents  [[:.dashboard              {:background-color (:day colors)
                                                   :align-items :stretch}]
                        [:.dashboard--logo        {:padding (:full units)
                                                   :padding-bottom (:two units)
                                                   :background-color (:primary colors)
                                                   :flex-grow 0
                                                   :flex-direction :row
                                                   :height         (:three units)}]
                        [:.dashboard--main        {:height :auto
                                                   :flex-grow 0}]
                        [:.dashboard--nav         {:height :auto}]]
        overrides       [[(s/> :.layout--dashboard (s/attr :data-colorful := :true))
                          {:background-color (:primary colors)}]]]
    [(h/augment-many base-component subcomponents)
     overrides]))

