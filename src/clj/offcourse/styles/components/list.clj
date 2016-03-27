(ns offcourse.styles.components.list
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden.selectors :as s]
            [offcourse.styles
             [classes :refer [checkbox list list--item]]
             [modifiers :refer [hovered removable selected]]]))

(def todo-list (list (s/attr :data-list-type := :todo)))
(def edit-list (list (s/attr :data-list-type := :edit)))
(def checkpoint-list (list (s/attr :data-list-type := :checkpoint)))

(defn list-component [{:keys [templates borders colors fonts units]}]

  [[list        (merge (:column-component templates))
    [list--item (merge (:row-component templates)
                       (:recycled-paper templates)
                       (:subtitle-font templates)
                       {:justify-content :space-between
                        :margin-bottom   (:sixth units)
                        :align-items     :center
                        :padding         (:half units)
                        :flex            1
                        :height          (:one-and-half units)})]]


   [edit-list
    [list--item
     [:.btn--remove
      [removable {:color       (:medium colors)
                  :user-select :none}
       [hovered {:color (:primary colors)}]]]]]

   [todo-list
    [list--item {:justify-content :flex-start}
     [hovered (:highlighted templates)]
     [selected (:selected templates)
      [hovered (:highlighted templates)]]

     [checkbox (merge (:component templates)
                      (:paper templates)
                      {:display          :flex
                       :margin-right     (:two-third units)
                       :width            (:two-third units)
                       :height           (:two-third units)})]]]])
