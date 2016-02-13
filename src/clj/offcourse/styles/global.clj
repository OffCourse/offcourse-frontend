(ns offcourse.styles.global
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [/ + *]]]))

(defn global [{:keys [templates colors units fonts]}]
  [[:*     {:margin      0
            :padding     0
            :font-family (:base fonts)
            :user-select :none
            :box-sizing  :border-box}]
   [:ul {:list-style :none}]
   [:li :p {:font-size   (:base-font units)
         :line-height (:base-line-height units)}]
   [:html  :body :#container (:component templates)]])
