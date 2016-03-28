(ns offcourse.styles.components.menubar
  (:require [offcourse.styles.vocabulary :as v]))

(defn menubar [{:keys [templates colors units]}]
  [[v/menubar (merge (:row-component templates)
                     (:highlighted templates)
                     {:justify-content :space-between
                      :flex 1
                      :padding (:full units)})]])
