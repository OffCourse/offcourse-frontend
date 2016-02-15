(ns offcourse.styles.components.viewer
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))


(defn viewer [{:keys [templates colors fonts units]}]
  [[:.content {:width (percent 75)
               :display :block
               :max-width (px 1200)
               :padding (:full units)}
    [:h1 {:font-size (:title-font units)
          :margin-bottom (:full units)}]
    [:p {:font-size (* (/ (:full units) 3) 2)
         :line-height (:base-line-height units)
         :margin-bottom (:full units)}]]])
