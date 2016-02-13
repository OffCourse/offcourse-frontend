(ns offcourse.styles.global
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [percent px rem]]
             [stylesheet :refer [at-media]]
             [arithmetic :refer [/ + *]]]))

(defn global [{:keys [templates breakpoints colors units fonts]}]
  [[:*     {:margin      0
            :padding     0
            :font-family (:base fonts)
            :user-select :none
            :box-sizing  :border-box}]
   [:ul {:list-style :none}]
   [:html  :body :#container (:component templates)]
   (for [{:keys [min-width max-width percent]} breakpoints]
     (at-media {:min-width (px min-width) :max-width (px max-width)}
               [:html {:font-size   (u/percent percent)
                       :line-height (:base-line-height units)}]))])

