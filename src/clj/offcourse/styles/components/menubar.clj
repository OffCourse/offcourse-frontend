(ns offcourse.styles.components.menubar
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent]]
            [offcourse.styles.vocabulary :as v]))

(defn menubar [{:keys [templates colors units]}]
  [[v/menubar           (merge (:row-component        templates)
                               (:border-default       templates)
                               {:justify-content      :space-between
                                :align-items          :center
                                :flex                 1
                                :padding            [[0 (:full units) 0 0]]})]
   [v/menubar--section         {:display              :flex
                                :align-items          :center}
    [v/first            (merge (:negative             templates)
                               {:height              (percent 100)
                                :padding            [[0 (* 10 (:atom units))]]})]]
   [:.menubar--link     (merge (:text                 templates) 
                               {:margin             [[0 (:one-and-half units) 0 0]]})
    [v/hovered          (merge (:border-thin          templates)
                               (:border-highlighted   templates)
                               {:color               (:primary colors)
                                :cursor               :pointer})]]
   [:.actions-panel            (:row-component        templates)]])