(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.classes :as c]
            [offcourse.styles.modifiers :as m]))

(defn calculate-breakpoint [{:keys [min-width max-width column-count]} {:keys [column-gap column]}]
  (at-media {:min-width min-width :max-width max-width}
            (let [gap-count    (dec column-count)
                  actual-width (+ (* column-count column) (* gap-count column-gap))]
              [c/cards {:display      (if (= column-count 0) :none :block)
                        :column-count column-count
                        :min-width    actual-width
                        :max-width    actual-width}])))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  [[c/cards (merge (:component templates)
                   (:recycled-paper templates)
                   {:padding          (:full units)
                    :overflow-x       :hidden
                    :column-gap       (:column-gap units)})
    [c/container {:display :inline-block
                  :width (:column units)}]]

   (for [breakpoint breakpoints] (calculate-breakpoint breakpoint units))

   [c/card (merge (:component templates)
                  (:sheet templates)
                  {:padding [[0 (:full units)]]})
    [m/hovered (:highlighted borders)]

    [c/card--section (merge (:component templates)
                            {:padding [[0 0 (:full units) 0]]})
     [m/first {:padding-top    (:two-third units)
               :padding-bottom (:two-third units)}]
     [m/last {:padding-bottom (:one-and-half units)}]
     [c/title (:title-font templates)]]]])
