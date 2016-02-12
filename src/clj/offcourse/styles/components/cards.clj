(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.arithmetic :refer [* +]]
             [garden.stylesheet :refer [at-media]]))

(defn cards [{:keys [breakpoints templates units]}]
  (let [column-gap       (:one-and-half units)
        breakpoint-pairs (partition 2 1 breakpoints)]
    (for [min-max breakpoint-pairs]
      (let [[min max]    min-max
            column-count (.indexOf breakpoints min)
            cards-width  (+ (* column-count (:card units)) (* column-count column-gap))]
        (println column-count min)
        (at-media {:min-width min :max-width max}
                  [:.cards (merge (:component templates)
                                  {:display      (if (= column-count 0) :none :block)
                                   :padding      [[(:full units) 0 0 0]]
                                   :min-width    cards-width
                                   :max-width    cards-width
                                   :column-gap   column-gap
                                   :column-count column-count})])))))
