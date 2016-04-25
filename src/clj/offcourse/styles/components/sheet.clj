(ns offcourse.styles.components.sheet
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
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
     [:h1 (merge (:list-item templates)
                 (:title templates)
                 {:background-color (:day colors)
                  :padding-left 0})]]]

   [v/sheet--section (merge (:column-component templates)
                            {:flex 2
                             :padding (:full units)
                             :justify-content :center})
    [v/first {:flex [[0 0 (:column units)]]}
     [v/list--item (merge (:list-item templates)
                          (:tiny-font templates)
                          {:background-color (:day colors)})
      [v/first (:list-item templates)]]]
    [v/second {:padding-left 0}]]])


