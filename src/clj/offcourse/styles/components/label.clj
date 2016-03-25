(ns offcourse.styles.components.label
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))


(defn label [{:keys [templates fonts colors units]}]
  [[:.label {:display          :inline-flex
             :height           (:full units)
             :margin-right     (:sixth units)
             :margin-bottom    (:sixth units)
             :font-size        (* (:atom units) 18)
             :align-items      :center
             :font-family      (:base fonts)
             :font-weight      300
             :justify-content  :center
             :padding          [[0 (:half units)]]
             :color            (:night colors)
             :background-color (:light colors)}
    [:&:hover (:highlighted templates)]]
   [(s/> :.labels (s/attr :data-selected := :true)) (:selected templates)
    [:&:hover (:highlighted templates)]]])
