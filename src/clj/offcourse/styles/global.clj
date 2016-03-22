(ns offcourse.styles.global
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [units :as u :refer [percent px]]
             [stylesheet :refer [at-media]]
             [arithmetic :refer [/ + *]]]))

(defn global [{:keys [templates breakpoints colors units fonts]}]
  [[:*     {:margin      0
            :padding     0
            :user-select :none
            :box-sizing  :border-box}]
   [:ul {:list-style :none}]
   [:a  {:color :inherit
         :text-decoration :inherit}]
   [:html {:font-family (:base fonts)}]
   [:input {:border :none} [:&:focus {:outline :none}]]
   [:html  :body :#container (:component templates)]
   (for [{:keys [min-width max-width percent]} breakpoints]
     (at-media {:min-width min-width :max-width max-width}
               [:html {:font-size   percent
                       :line-height (:base-line-height units)}]))])

