(ns offcourse.styles.components.resource-list
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(defn resource-list [{:keys [templates colors fonts units]}]
  [[:.container {:display :inline-block
                 :padding [[(:full units) 0 0 0]]}]
   [:.resource-list  {:width            (percent 100)
                      :display          :flex
                      :padding-right    (:full units)
                      :background-color (:light colors)
                      :flex-direction   :column
                      :overflow-y :auto}]
   [:.resource-list--item {:padding (:full units)
                           :border-bottom    [[:solid (:sixth units) (:medium units)]]
                           :display          :flex
                           :justify-content  :space-between
                           :margin-bottom    (:full units)
                           :align-items      :center
                           :flex-wrap        :wrap
                           :background-color (:day colors)}
    [:.add-btn {:flex [[1]]}]
    [:.info   {:flex [[6]]}]
    [:.tags   {:flex [[4]]}
     [:.labels {:display :flex
                :justify-content :flex-end
                :flex-wrap :wrap}]]
    [:&:hover {:border-color [(:primary colors)]}]]])
