(ns offcourse.styles.graphs
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [* + /]]
             [units :as u :refer [percent px rem]]]
            [plumbing
             [core :refer [fnk]]
             [graph :as graph]]))

(defn -compose [graph config] ((graph/compile graph) config))
(def units-graph
  {:column               (fnk [full] (* full 14))
   :column-gap           (fnk [full] (* 1 full))
   :map                  (fnk [column] (/ column 2))
   :two                  (fnk [full] (* full 2))
   :one-and-half         (fnk [full] (* full 1.5))
   :two-third            (fnk [third] (* third 2))
   :half                 (fnk [full] (/ full 2))
   :subtitle-font        (fnk [atom] (* atom 22))
   :subtitle-line-height (fnk [atom] (* atom 30))
   :base-font            (fnk [atom] (* atom 16))
   :full                 (fnk [base-unit] (rem (/ base-unit 16)))
   :base-line-height     (fnk [atom] (* atom 20))
   :title-font           (fnk [atom] (* atom 28))
   :title-line-height    (fnk [full] full)
   :third                (fnk [full] (/ full 3))
   :sixth                (fnk [full] (/ full 6))
   :tenth                (fnk [full] (/ full 10))
   :atom                 (fnk [full] (/ full 30))})

(def templates-graph
  {:border    (fnk [units colors] [[(:atom units) :solid (:night colors)]])
   :component (fnk [] {:display        :flex
                       :flex-direction :column
                       :width          (percent 100)
                       :height         (percent 100)
                       :padding        0
                       :margin         0})})

(def config-graph
  {:colors      (fnk [raw-colors base-color]
                     {:night   (:black raw-colors)
                      :dark    (:dark-gray   raw-colors)
                      :medium  (:medium-gray raw-colors)
                      :light   (:light-gray  raw-colors)
                      :day     (:white raw-colors)
                      :primary (base-color raw-colors)})
   :breakpoints (fnk [raw-breakpoints]
                     (map (fn [{:keys [min-width max-width percent column-count]}]
                            {:min-width (px min-width)
                             :max-width (px max-width)
                             :percent   (u/percent percent)
                             :column-count column-count})
                          raw-breakpoints))
   :fonts       (fnk [raw-fonts base-font title-font]
                     {:base  base-font
                      :title title-font
                      :raw   (vals raw-fonts)})
   :units       (fnk [base-unit] (-compose units-graph {:base-unit base-unit}))
   :templates   (fnk [units colors]
                     (-compose templates-graph {:units  units
                                               :colors colors}))})


(def compose (partial -compose config-graph))
