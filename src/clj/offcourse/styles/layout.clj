(ns offcourse.styles.layout
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.units :as u :refer [vh]]
            [garden.arithmetic :refer [*]]
            [offcourse.styles.vocabulary :as v]))

(defn layout [{:keys [templates units colors]}]
  [[v/layout        (merge (:column-component templates)
                           (:paper templates)
                           {:flex 1
                            :height           (vh 100)
                            :align-content    :stretch
                            :overflow         :hidden})
    [v/layout--section (merge (:row-component templates)
                              {:flex 1})
     [v/first {:flex [[0 0 (:two units)]]}]]]

   [v/main (merge (:row-component templates)
                  (:recycled-paper templates)
                  {:flex 1})
    [v/main--section
     [v/last (merge (:row-component templates)
                    (:recycled-paper templates)
                    {:flex 2
                     :overflow       :scroll})]]]

   [v/container (merge (:row-component templates)
                       {:padding [[0 0 (:two-third units) 0]]})]])
