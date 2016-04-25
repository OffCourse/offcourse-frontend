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
    [v/content
     [:h1 (merge (:title templates)
                 {:padding 0
                  :padding-bottom (:two-third units)})]]]

   [v/sheet--section (merge (:column-component templates)
                            {:flex 2
                             :padding (:full units)
                             :justify-content :center})
    [v/first {:flex [[0 0 (:column units)]]}
     [v/list {:padding [[0 0 (:two-third units) 0]]}
      [v/list--item {:background-color (:day colors)
                     :font-family (:base fonts)}
       [v/hovered {:color (:primary colors)}]
       [v/first (:list-item templates)
        [v/hovered (:selected templates)]]]]]
    [v/second {:padding-left 0}]]])

