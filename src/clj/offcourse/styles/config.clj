(ns offcourse.styles.config
  (:refer-clojure :exclude [+ - * /])
  (:require  [garden.units :as u :refer [px vh vw percent]]))

(def colors
  {:black      "#000000"
   :white      "#FFFFFF"
   :darkgray   "#3d3d3d"
   :mediumgray "#c0c4c1"
   :lightgray  "#f4f6f4"
   :yellow     "#E5CF39"
   :green      "#A5CC45"
   :blue       "#75C7B3"
   :red        "#E34D2F"})

(def fonts         [["NittiGrotesk" "NGN"]
                    ["NittiNormal" "NN"]
                    ["NittiGroteskBold" "NGB"]
                    ["NittiBold" "NB"]])

(def base-component {:display :flex
                     :flex-direction :column
                     :width (percent 100)
                     :height (percent 100)
                     :padding 0
                     :margin 0})

(def config
  {:fonts          fonts
   :colors         colors
   :base-component base-component
   :base-font      "NittiGrotesk"
   :base-unit      (px 30)
   :title-font     "NittiBold"
   :base-color-fg  (:black colors)
   :base-color-bg  (:white colors)
   :primary-color  (:yellow colors)})
