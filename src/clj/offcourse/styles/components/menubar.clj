(ns offcourse.styles.components.menubar
  (:require [offcourse.styles.vocabulary :as v]))

(defn menubar [{:keys [templates colors units]}]
  [[v/menubar (merge (:row-component templates)
                     (:highlighted templates)
                     {:justify-content :space-between
                      :align-items :center
                      :flex 1
                      :padding [[(:two-third units)(:full units)]]})]
   [v/menubar--section {:height (:full units)
                        :display :flex
                        :align-items :center}]])
