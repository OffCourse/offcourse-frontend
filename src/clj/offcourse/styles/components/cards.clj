(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.arithmetic :refer [* +]]))

(defn cards [{:keys [templates units]}]
  (let [column-gap   (:one-and-half units)
        column-count 7
        cards-width  (+ (* column-count (:card units)) (* column-count column-gap))]
    [:.cards (merge (:component templates)
                    {:display              :block
                     :padding              [[(:full units) 0 0 0]]
                     :min-width            cards-width
                     :max-width            cards-width
                     :-webkit-column-gap   column-gap
                     :-webkit-column-count column-count})]))
