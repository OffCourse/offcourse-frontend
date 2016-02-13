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
   :column-gap           (fnk [full] (* 1.5 full))
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

(def config (compose config-graph {:raw-colors colors
                                   ;; :base-unit  (* (px 30) 0.55)    ;; 1024
                                   ;; :base-unit  (* (px 30) 0.67)    ;; 1280
                                   ;; :base-unit  (* (px 30) 0.73)    ;; 1440
                                   ;; :base-unit  (* (px 30) 0.82)    ;; 1600
                                   ;; :base-unit  (* (px 30) 0.80)    ;; 1920
                                   ;; :base-unit  (* (px 30) 0.88)    ;; 2048
                                   ;; :base-unit  (* (px 30) 0.88)    ;; 2560
                                   ;; :base-unit  (* (px 30) 0.97)    ;; 3200
                                   :base-unit     (* (px 30) 1)       ;; 3840
                                   :base-color :green
                                   :raw-fonts  fonts
                                   :min-width  (px 1024)
                                   :base-font  :NittiGrotesk
                                   :title-font :NittiBold}))
