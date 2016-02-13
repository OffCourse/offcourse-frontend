(ns offcourse.styles.layout
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [vh vw percent]]]))

(defn layout [{:keys [units colors]}]
  [[:.layout--app        {:display          :flex
                          :height           (vh 100)
                          :width            (vw 100)
                          :background-color (:light colors)}]
   [:.layout--dashboard  {:height    (percent 100)
                          :min-width (:column units)
                          :max-width (:column units)}]
   [:.layout--main       {:justify-content :center
                          :display         :flex
                          :flex-direction  :row
                          :width           (percent 100)
                          :overflow-y      :scroll}]])
