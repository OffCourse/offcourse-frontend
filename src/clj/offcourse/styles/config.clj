(ns offcourse.styles.config
  (:require [offcourse.styles.graphs :as graphs]))

(def fonts {:NittiGrotesk     ["NittiGrotesk" "NGN"]
            :NittiNormal      ["NittiNormal" "NN"]
            :NittiGroteskBold ["NittiGroteskBold" "NGB"]
            :NittiBold        ["NittiBold" "NB"]})

(def colors        {:black       "#000000"
                    :white       "#FFFFFF"
                    :dark-gray   "#3d3d3d"
                    :medium-gray "#e0e4e1"
                    :light-gray  "#f4f6f4"
                    :very-light-gray  "#f8f9f8"
                    :yellow      "#E5CF39"
                    :green       "#19A196"
                    :green-dark  "#3A676E"
                    :orange      "#F96220"
                    :orange-dark "#A25418"
                    :blue        "#75C7B3"
                    :red         "#E34D2F"})

(def breakpoints [{:min-width 0    :max-width 767  :percent 55  :column-count 0}
                  {:min-width 768  :max-width 899  :percent 55  :column-count 3}
                  {:min-width 900  :max-width 1023 :percent 66  :column-count 3}
                  {:min-width 1024 :max-width 1279 :percent 55  :column-count 4}
                  {:min-width 1280 :max-width 1439 :percent 70  :column-count 4}
                  {:min-width 1440 :max-width 1599 :percent 80  :column-count 4}
                  {:min-width 1600 :max-width 1920 :percent 71  :column-count 5}
                  {:min-width 1920 :max-width 2047 :percent 85  :column-count 5}
                  {:min-width 2048 :max-width 2560 :percent 90  :column-count 5}
                  {:min-width 2560 :max-width 3200 :percent 94  :column-count 6}
                  {:min-width 3200 :max-width 3839 :percent 100 :column-count 7}
                  {:min-width 3840 :max-width 9999 :percent 100 :column-count 8}])

(def config (graphs/compose {:raw-colors      colors
                             :raw-breakpoints breakpoints
                             :base-unit       30
                             :base-color      :orange
                             :raw-fonts       fonts
                             :base-font       :NittiGrotesk
                             :logo-font       :NittiBold
                             :title-font      :NittiGroteskBold}))
