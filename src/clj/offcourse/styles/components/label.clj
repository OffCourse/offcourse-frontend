(ns offcourse.styles.components.label
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))


(defn label [{:keys [templates colors units]}]
  [[:.label {:display          :inline-flex
             :height           (:full units)
             :margin-right     (:sixth units)
             :margin-bottom    (:sixth units)
             :font-size        (* (:atom units) 13)
             :align-items      :center
             :justify-content  :center
             :padding          [[0 (:third units)]]
             :border           (:border templates)
             :background-color (:day colors)}]
   [(s/> :.labels (s/attr :data-selected := :true)) (:selected templates)]])
