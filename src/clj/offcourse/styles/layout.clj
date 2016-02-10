(ns offcourse.styles.layout
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [percent]]]))

(defn layout [{:keys [base-color-fg base-unit base-color-bg]}]
  [[:.layout--app {:display :flex
                   :height  (percent 100)}]
   [:.layout--dashboard  {:height (percent 100)
                          :width  (* 12 base-unit)}]])
