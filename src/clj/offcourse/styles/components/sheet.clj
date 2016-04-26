(ns offcourse.styles.components.sheet
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent px rem]]
            [offcourse.styles.vocabulary :as v]))

(defn sheet [{:keys [templates borders colors fonts units]}]

  [[v/sheets (merge (:column-component templates)
                   {:padding-top (:full units)
                    :display :block
                    :flex             1
                    :background-color (:light colors)
                    :padding-right    (:full units)})]

   [v/sheet (merge (:row-component templates)
                   (:sheet templates)
                   {:flex 1
                    :justify-content  :center
                    :align-items      :flex-start})
    [v/hovered (:highlighted borders)]
    [v/content (:text templates)
     [v/title (merge (:title templates)
                 {:padding 0
                  :padding-bottom (:two-third units)})]]]

   [v/sheet--section (merge (:column-component templates)
                            {:flex 2
                             :padding (:full units)
                             :justify-content :center})
    [v/first {:flex [[0 0 (:column units)]]}
     [v/list
      [v/list--item {:background-color (:day colors)
                     :padding-top 0
                     :line-height (:base-line-height units)
                     :height (percent 100)
                     :padding-bottom 0
                     :margin-bottom (:full units)
                     :font-size (:tag-font units)
                     :font-family (:base fonts)}
       [v/hovered {:color (:primary colors)}]
       [v/first (merge (:list-item templates)
                       {:margin-bottom (:full units)})
        [v/hovered (:selected templates)]]]]]
    [v/second {:padding-left 0}]]])

