(ns offcourse.styles.components.dashboard
  (:require [offcourse.styles.helpers :as h]
            [garden
             [units :as u :refer [px percent]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]
            [offcourse.styles.classes :as c]))

(defn dashboard [{:keys [templates colors units]}]
  (let [base-component (:component templates)

        subcomponents  [[:.dashboard              {:padding (:full units)
                                                   :align-items :stretch}]
                        [:.dashboard--main        {:height :auto
                                                   :flex-grow 0}]
                        [:.dashboard--nav         {:height :auto}]]

        overrides       [[:.dashboard [c/container {:width (:column units)}]]
                         [:.dashboard--main [:.card {:border :none}]]
                         [(s/> :.layout--dashboard (s/attr :data-colorful := :true))
                          {:background-color (:primary colors)}]]]
    [(h/augment-many base-component subcomponents)
     overrides]))

