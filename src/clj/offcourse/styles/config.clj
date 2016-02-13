(ns offcourse.styles.config
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [* + /]]
             [units :as u :refer [percent px rem]]]
            [plumbing
             [core :refer [fnk]]
             [graph :as graph]]))

(defn compose [graph config] ((graph/compile graph) config))

(def units-graph
  {:min-screen-width     (fnk [min-width] (rem (/ (:magnitude min-width) 16)))
   :column               (fnk [full] (* full 14))
   :column-gap           (fnk [full] (* 1 full))
   :extended-column      (fnk [column column-gap] (+ column-gap column))
   :card                 (fnk [column] column)
   :sidebar              (fnk [card] card)
   :map                  (fnk [column] (/ column 2))
   :two                  (fnk [full] (* full 2))
   :one-and-half         (fnk [full] (* full 1.5))
   :two-third            (fnk [third] (* third 2))
   :half                 (fnk [full] (/ full 2))
   :subtitle-font        (fnk [atom] (* atom 22))
   :subtitle-line-height (fnk [atom] (* atom 30))
   :base-font            (fnk [atom] (* atom 16))
   :full                 (fnk [base-unit] (rem (/ (:magnitude base-unit) 16)))
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

(def fonts {:NittiGrotesk     ["NittiGrotesk" "NGN"]
            :NittiNormal      ["NittiNormal" "NN"]
            :NittiGroteskBold ["NittiGroteskBold" "NGB"]
            :NittiBold        ["NittiBold" "NB"]})

(def colors        {:black       "#000000"
                    :white       "#FFFFFF"
                    :dark-gray   "#3d3d3d"
                    :medium-gray "#c0c4c1"
                    :light-gray  "#f4f6f4"
                    :yellow      "#E5CF39"
                    :green       "#A5CC45"
                    :blue        "#75C7B3"
                    :red         "#E34D2F"})

(def config-graph
  {:colors      (fnk [raw-colors base-color]
                     {:night   (:black raw-colors)
                      :dark    (:dark-gray   raw-colors)
                      :medium  (:medium-gray raw-colors)
                      :light   (:light-gray  raw-colors)
                      :day     (:white raw-colors)
                      :primary (base-color raw-colors)})
   :breakpoints (fnk [raw-breakpoints] raw-breakpoints)
   :fonts       (fnk [raw-fonts base-font title-font]
                     {:base  base-font
                      :title title-font
                      :raw   (vals raw-fonts)})
   :units       (fnk [base-unit min-width]
                     (compose units-graph {:base-unit base-unit
                                           :min-width min-width}))
   :templates   (fnk [units colors]
                     (compose templates-graph {:units  units
                                               :colors colors}))})

(def breakpoints [{:min-width 0    :max-width 767  :percent 55  :column-count 0}
                  {:min-width 768  :max-width 899  :percent 55  :column-count 2}
                  {:min-width 900  :max-width 1023 :percent 66  :column-count 2}
                  {:min-width 1024 :max-width 1279 :percent 55  :column-count 3}
                  {:min-width 1280 :max-width 1439 :percent 70  :column-count 3}
                  {:min-width 1440 :max-width 1599 :percent 80  :column-count 3}
                  {:min-width 1600 :max-width 1920 :percent 71  :column-count 4}
                  {:min-width 1920 :max-width 2047 :percent 85  :column-count 4}
                  {:min-width 2048 :max-width 2560 :percent 90  :column-count 4}
                  {:min-width 2560 :max-width 3200 :percent 94  :column-count 5}
                  {:min-width 3200 :max-width 3480 :percent 100 :column-count 6}
                  {:min-width 3840 :max-width 9999 :percent 100 :column-count 7}])

(def config (compose config-graph {:raw-colors colors
                                   :raw-breakpoints breakpoints
                                   :base-unit     (px 30)
                                   :base-color :green
                                   :raw-fonts  fonts
                                   :min-width  (px 1024)
                                   :base-font  :NittiGrotesk
                                   :title-font :NittiBold}))
