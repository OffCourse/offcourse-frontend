(ns offcourse.styles.components.cards
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* + - /]]
             [stylesheet :refer [at-media]]]))

(defn cards [{:keys [templates units]}]
  (let [{:keys [breakpoints column column-gap min-screen-width full half extended-column]} units
        breakpoints         (conj (map #(+ (* % (/ extended-column 4)) min-screen-width) (range 30)) 0)
        breakpoint-pairs                      (partition 2 1 breakpoints)]
    (for [min-max breakpoint-pairs]
      (let [[min max]    min-max
            container-width (- min extended-column)
            column-count (int (Math/floor (:magnitude (/ container-width extended-column))))
            gap-count     (dec column-count)
            actual-width (+ (* column-count column) (* gap-count column-gap))
            padding-sides (/ (- container-width actual-width) 2)]
        (println (map :magnitude [container-width actual-width padding-sides]))
        (at-media {:min-width min :max-width max}
                  [:.cards (merge (:component templates)
                                  {:display      (if (= column-count 0) :none :block)
                                   :padding      [[full padding-sides 0 padding-sides]]
                                   :overflow-x   :hidden
                                   :min-width    container-width
                                   :max-width    container-width
                                   :margin       :auto
                                   :column-gap   column-gap
                                   :column-count column-count})])))))
