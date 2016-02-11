(ns offcourse.styles.components.card
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [vw vh percent px]]
             [arithmetic :refer [/ + *]]]))

(defn cards [{:keys [base-component card-width base-color-medium base-unit]}]
  (let [column-gap (* 1.5 base-unit)
        column-count 7
        cards-width (+ (* column-count card-width) (* column-count column-gap))]
    [:.cards (merge base-component {:display :block
                                    :padding [[base-unit 0 0 0]]
                                    :min-width cards-width
                                    :max-width cards-width
                                    :-webkit-column-gap column-gap
                                    :-webkit-column-count column-count})]))


(defn card [{:keys [base-component card-width base-unit base-color-medium base-color-dark base-color-light]}]
  (let [map-height (* (/ card-width 12) 7)
        card-section {:padding [[0 base-unit (/ base-unit 2) base-unit]]}]

    [[:.layout--card {:display :inline-block
                      :padding [[0 0 (* 1.5 base-unit) 0]]
                      :background-color base-color-medium}]
     [:.card (merge base-component {:width card-width
                                    :padding-bottom base-unit
                                    :background-color base-color-light})]
     [:.card--map (merge base-component {:height map-height
                                         :background-color base-color-dark})]
     [:.card--title (merge card-section {:padding-top base-unit
                                         :padding-bottom 0})
      [:.title {:font-size (px 28)
                :font-weight 500
                :line-height (px 30)}]]
     [:.card--meta (merge card-section {:padding [[(/ base-unit 2) base-unit]]})
      [:.keyword {:margin-right (/ base-unit 10)}]]
     [:.card--tags (merge card-section {:padding-top (/ base-unit 2)})]
     [:.card--checkpoints (merge card-section {:padding-top (/ base-unit 2)})]
     [:.card--description card-section]]))

