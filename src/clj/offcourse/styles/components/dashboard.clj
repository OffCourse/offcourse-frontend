(ns offcourse.styles.components.dashboard
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [px]]]))

(defn dashboard [{:keys [base-font base-component primary-color base-unit]}]
  [[:.dashboard (merge base-component {:background-color primary-color
                                       :padding          (px 30)})]
   [:.dashboard__logo (merge base-component {:padding-bottom (px 30)
                                             :flex-direction :row
                                             :height         (* 2 base-unit)})]
   [:.dashboard__collections base-component ]])
