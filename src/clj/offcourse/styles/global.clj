(ns offcourse.styles.global
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [/ + *]]]))

(defn global [{:keys [base-component base-unit base-font]}]
  [[:*     {:margin      0
            :padding     0
            :font-family base-font
            :-webkit-user-select  :none
            :box-sizing  :border-box}]
   [:ul {:list-style :none}]

   [:li {:font-size (* (/ base-unit 30) 16)
        :line-height (* (/ base-unit 30) 20)}]
   [:p {:font-family base-font
        :font-size (* (/ base-unit 30) 16)
        :line-height (* (/ base-unit 30) 20)}]
   [:html  base-component]
   [:body  base-component]
   [:#container base-component]])
