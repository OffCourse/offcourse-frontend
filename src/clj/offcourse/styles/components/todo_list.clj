(ns offcourse.styles.components.todo-list
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [vw vh percent px]]
             [selectors :as s]
             [arithmetic :refer [/ + *]]]))

(defn todo-list [{:keys [templates fonts units colors]}]
  [[:.todo-list--item {:justify-content  :center
                       :padding          (:half units)
                       :height           (:one-and-half units)
                       :margin-bottom    (:sixth units)
                       :background-color (:light colors)
                       :color            (:night colors)}
    [:&:hover (:highlighted templates)]
    [:p {:display         :flex
         :flex-direction  :row
         :font-size       (:subtitle-font units)
         :font-family     (:title fonts)
         :font-weight     500
         :line-height     (:subtitle-line-height units)
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

