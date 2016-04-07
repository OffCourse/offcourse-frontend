(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* +]]
             [stylesheet :refer [at-media]]]
            [offcourse.styles.vocabulary :as v]))

(defn calculate-breakpoint [{:keys [min-width max-width column-count]} {:keys [column-gap column]}]
  (at-media {:min-width min-width :max-width max-width}
            (let [gap-count    (dec column-count)
                  actual-width (+ (* column-count column) (* gap-count column-gap))]
              [v/cards {:display      (if (= column-count 0) :none :block)
                        :column-count column-count
                        :min-width    actual-width
                        :max-width    actual-width}])))

(defn cards [{:keys [templates breakpoints borders colors units]}]
  [[v/cards (merge (:row-component templates)
                   (:recycled-paper templates)
                   {:padding          (:full units)
                    :column-gap       (:column-gap units)})
    [v/container {:display :inline-block
                  :width (:column units)}]]

   (for [breakpoint breakpoints] (calculate-breakpoint breakpoint units))

   [v/card (merge (:column-component templates)
                  (:sheet templates)
                  {:padding [[0 (:full units)]]
                   :flex 1})
    [v/hovered (:highlighted borders)]

    [v/card--section (merge (:component templates)
                            {:padding [[0 0 (:full units) 0]]})
     [v/first {:padding-top    (:two-third units)
               :padding-bottom (:two-third units)}]
     [v/last {}]]]])
