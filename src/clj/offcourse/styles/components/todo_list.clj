(ns offcourse.styles.components.todo-list
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [vw vh percent px]]
             [selectors :as s]
             [arithmetic :refer [/ + *]]]))

(defn todo-list [{:keys [templates units colors]}]
  [[:.todo-list--item {:justify-content  :center
                       :padding          (:sixth units)
                       :height           (:full units)
                       :margin-bottom    (:sixth units)
                       :background-color (:light colors)
                       :color            (:night colors)}
    [:p {:display         :flex
         :flex-direction  :row
         :justify-content :flex-start
         :align-items     :center
         :height          (percent 100)}]
    [:.checkbox {:display          :inline-block ;
                 :margin-right     (:third units)
                 :width            (:two-third units)
                 :height           (:two-third units)
                 :background-color (:day colors)
                 :vertical-align   :center}]]
   [(s/> :.todo-list (s/attr :data-selected := :true)) (:selected templates)]])

