(ns offcourse.styles.layout
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [vh vw percent]]]))

(defn layout [{:keys [card-width base-color-medium]}]
  [[:.layout--app {:display :flex
                   :height  (vh 100)
                   :width   (vw 100)}]
   [:.layout--dashboard  {:height (percent 100)
                          :min-width  card-width
                          :max-width  card-width}]
   [:.layout--main {:justify-content :center
                    :display :flex
                    :background-color base-color-medium
                    :flex-direction :row
                    :width (percent 100)
                    :overflow-y :scroll}]])
