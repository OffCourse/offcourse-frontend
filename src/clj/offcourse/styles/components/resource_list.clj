(ns offcourse.styles.components.resource-list
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(s/defclass list)
(def checkpoint-list (list (s/attr :data-list-type := :checkpoint)))

(defn resource-list [{:keys [templates colors fonts units]}]

  [[checkpoint-list {:padding-top (:full units)
                     :background-color (:light colors)
                     :padding-right    (:full units)}

    [:.list--item {:padding          (:full units)
                   :border-bottom    [[:solid (:sixth units) (:medium units)]]
                   :min-height       (* 5 (:full units))
                   :justify-content  :space-between
                   :margin-bottom    (:two-third units)
                   :background-color (:day colors)}]

    [:.btn--add {:flex         [[0 0 (:full units)]]
                 :font-weight  700
                 :margin-right (:full units)
                 :font-size    (:one-and-half units)}
     [:&:hover {:color (:primary colors)}]]

    [:.info   {:flex            [[9]]
               :justify-content :space-between
               :flex-direction  :column}

     [:.title :.url {:display       :flex
                     :flex          1
                     :margin-bottom (:third units)}]
     [:.url :.resource_title :.tag {:font-size (:subtitle-font units)}]
     [:.url :.resource_title :.tag {:font-family (:base fonts)
                                    :font-size   (:subtitle-font units)}]]
    [:.tags   {:flex            [[6]]
               :display         :flex
               :flex-direction  :column
               :justify-content :flex-end}
     [:.labels {:display         :flex
                :margin-bottom   (:full units)
                :justify-content :flex-end
                :flex-wrap       :wrap}]
     [:.tag {:font-size    (:subtitle-font units)
             :width        (:five units)
             :text-align   :right
             :margin-right (:full units)}]
     [:.submit {:font-size        (:full units)
                :text-align       :right
                :font-weight      700
                :background-color (:day colors)}]
     [:.tag--input {:display         :flex
                    :flex-direction  :row
                    :justify-content :flex-end
                    :flex            1}]]
    [:&:hover {:border-color [(:primary colors)]}]
    #_[(s/attr :data-form := :true)
       {:min-height (* 6 (:full units))}]]])
