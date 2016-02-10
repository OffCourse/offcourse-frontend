(ns offcourse.styles.config
  (:refer-clojure :exclude [+ - * /])
  (:require  [garden.units :as u :refer [px vh vw percent]]
             [plumbing.core :refer [fnk]]
             [plumbing.graph :as graph]
             [garden [arithmetic :refer [* /]]]))

(def graph
  {:colors         (fnk [] {:black      "#000000"
                            :white      "#FFFFFF"
                            :darkgray   "#3d3d3d"
                            :mediumgray "#c0c4c1"
                            :lightgray  "#f4f6f4"
                            :yellow     "#E5CF39"
                            :green      "#A5CC45"
                            :blue       "#75C7B3"
                            :red        "#E34D2F"})
   :fonts          (fnk [] [["NittiGrotesk" "NGN"]
                            ["NittiNormal" "NN"]
                            ["NittiGroteskBold" "NGB"]
                            ["NittiBold" "NB"]])
   :base-component (fnk [] {:display        :flex
                            :flex-direction :column
                            :width          (percent 100)
                            :height         (percent 100)
                            :padding        0
                            :margin         0})
   :base-font      (fnk [] "NittiGrotesk")
   :title-font     (fnk [] "NittiBold")
   :base-unit      (fnk [] (px 30))
   :base-border    (fnk [base-unit colors]
                        [[(/ base-unit 30) :solid (:black colors)]])
   :base-color-fg  (fnk [colors] (:black colors))
   :base-color-bg  (fnk [colors] (:white colors))
   :primary-color  (fnk [colors] (:yellow colors))})

(def compose (graph/compile graph))
(def config (compose {}))
