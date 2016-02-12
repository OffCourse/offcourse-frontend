(ns offcourse.styles.config
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]]
            [plumbing
             [core :refer [fnk]]
             [graph :as graph]]))

(defn compose [graph config] ((graph/compile graph) config))

(def units-graph
  {:column               (fnk [base-unit] (* base-unit 14))
   :card                 (fnk [column]    column)
   :sidebar              (fnk [card]      card)
   :map                  (fnk [column]    (/ column 2))
   :two                  (fnk [base-unit] (* base-unit 2))
   :one-and-half         (fnk [base-unit] (* base-unit 1.5))
   :full                 (fnk [base-unit] base-unit)
   :two-third            (fnk [third]     (* third 2))
   :half                 (fnk [base-unit] (/ base-unit 2))
   :subtitle-font        (fnk [atom]      (* atom 22))
   :subtitle-line-height (fnk [atom]      (* atom 30))
   :base-font            (fnk [atom]      (*  atom 16))
   :base-line-height     (fnk [atom]      (* atom 20))
   :title-font           (fnk [atom]      (* atom 28))
   :title-line-height    (fnk [base-unit] base-unit)
   :third                (fnk [base-unit] (/ base-unit 3))
   :sixth                (fnk [base-unit] (/ base-unit 6))
   :tenth                (fnk [base-unit] (/ base-unit 10))
   :atom                 (fnk [base-unit] (/ base-unit 30))})

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
  {:colors    (fnk [raw-colors base-color]
                   {:night   (:black raw-colors)
                    :dark    (:dark-gray   raw-colors)
                    :medium  (:medium-gray raw-colors)
                    :light   (:light-gray  raw-colors)
                    :day     (:white raw-colors)
                    :primary (base-color raw-colors)})
   :fonts     (fnk [raw-fonts base-font title-font]
                   {:base  base-font
                    :title title-font
                    :raw   (vals raw-fonts)})
   :units     (fnk [base-unit]
                   (compose units-graph {:base-unit base-unit}))
   :templates (fnk [units colors]
                   (compose templates-graph {:units  units
                                             :colors colors}))})

(def config (compose config-graph {:raw-colors colors
                                   :base-unit  (px 30)
                                   :base-color :green
                                   :raw-fonts  fonts
                                   :base-font  :NittiGrotesk
                                   :title-font :NittiBold}))
