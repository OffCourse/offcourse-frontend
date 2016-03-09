(ns offcourse.styles.components.viewer
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))


(defn viewer [{:keys [templates colors fonts units]}]
  [[:.viewer  {:width (percent 100)
               :background-color (:day colors)
               :overflow-y :auto}]
    [:.content {:display      :block
                :max-width    (* 33 (:full units))
                :padding      (:full units)
                :padding-left (:full units)}
    [:h1 {:font-size     (* 2 (:title-font units))
          :line-height   (* 1.8 (:title-line-height units))
          :margin-bottom (:full units)
          :font-family   (:title fonts)}]
    [:p {:font-size     (* 1.5 (:base-font units))
         :line-height   (* 1.5 (:base-line-height units))
         :margin-bottom (:full units)}]]])
