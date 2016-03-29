(ns offcourse.styles.components.list
  (:refer-clojure :exclude [first last list])
  (:require [offcourse.styles.vocabulary :as v]))

(defn list-component [{:keys [templates borders colors fonts units]}]

  [[v/list        (merge (:column-component templates))
    [v/list--item (merge (:row-component templates)
                       (:recycled-paper templates)
                       (:title templates)
                       {:margin-bottom   (:sixth units)
                        :align-items     :center
                        :font-size       (:subtitle-font units)
                        :padding         (:half units)
                        :height          (:one-and-half units)})]]

   [v/edit-list
    [v/list--item {:justify-content :space-between}]]

   [v/todo-list
    [v/list--item {:justify-content :flex-start}
     [v/hovered (:selected templates)]
     [v/selected (:highlighted templates)]]]])
