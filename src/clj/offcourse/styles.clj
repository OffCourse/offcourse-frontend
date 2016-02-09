(ns offcourse.styles
  (:require [garden.core :refer [css]]
            [garden.units :as u :refer [px vh vw percent]]
            [garden.stylesheet :refer [at-font-face]]
            [garden.selectors :refer [defclass defid]]
            [garden.def :refer [defrule defstyles]]))

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

(def config
  {:fonts         [["NittiGrotesk" "NGN"]
                   ["NittiNormal" "NN"]
                   ["NittiGroteskBold" "NGB"]
                   ["NittiBold" "NB"]]
   :base-font     "NittiNormal"
   :base-color-fg (:black colors)
   :base-color-bg (:white colors)
   :primary-color (:yellow colors)})

(defn make-at-font-face [[font-name file-name]]
  (at-font-face {:font-family font-name
                 :font-weight 300
                 :src  (str "url('/fonts/" file-name ".woff') " "format('woff')")}))

(defn global [{:keys [base-font]}]
  [:*     {:margin           0
           :padding          0
           :font-family      base-font
           :height           (vh 100)
           :width            (vw 100)
           :box-sizing       :border-box}])

(defn layout [{:keys [base-color-fg base-color-bg]}]
  [[:.layout-app {:display         :flex
                   :flex-direction  :row
                   :justify-content :flex-start
                   :color            base-color-fg
                   :background-color base-color-bg
                   :height          (percent 100)}]

   [:.layout-dashboard  {:flex-direction :row
                        :height         (percent 100)
                        :width          (px 300)}]])

(defn dashboard-component [{:keys [primary-color]}]
  [:.dashboard {:background-color primary-color
                :padding          (px 15)
                :height           (percent 100)
                :width            (percent 100)}])

(defstyles base
  (map make-at-font-face (:fonts config))
  (global config)
  (layout config)
  (dashboard-component config))
