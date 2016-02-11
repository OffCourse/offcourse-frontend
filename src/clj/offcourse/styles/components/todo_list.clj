(ns offcourse.styles.components.todo-list
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [vw vh percent px]]
             [arithmetic :refer [/ + *]]]))

(defn todo-list [{:keys [base-unit base-color-dark base-color-light base-color-medium]}]
  [[:.todo-list--item {:justify-content :center
                       :padding (/ base-unit 6)
                       :background-color base-color-medium
                       :height base-unit
                       :margin-bottom (/ base-unit 6)
                       :color base-color-dark}]

   [:p {:display :flex
        :flex-direction :row
        :justify-content :flex-start
        :align-items :center
        :height (percent 100)}]

   [:.checkbox {:display :inline-block;
                :margin-right (/ base-unit 3)
                :width (* 2 (/ base-unit 3))
                :height (* 2 (/ base-unit 3))
                :background-color base-color-light
                :vertical-align :center}]])

