(ns offcourse.styles.components.list
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden
             [units :as u :refer [vw vh percent px]]
             [selectors :as s]
             [arithmetic :refer [/ + *]]]))

(s/defclass list)
(s/defclass list--item)
(s/defclass checkbox)
(s/defpseudoclass hover)

(def todo-list (list (s/attr :data-list-type := :todo)))
(def edit-list (list (s/attr :data-list-type := :edit)))
(def removable (s/attr :data-remove := :true))

(def selected (s/attr :data-selected := :true))
(def hovered (s/& hover))

(defn list-component [{:keys [templates colors fonts units]}]

  [[list  {:display          :flex
           :flex             1
           :background-color (:day colors)
           :flex-direction   :column}
    [list--item {:justify-content  :space-between
                 :margin-bottom    (:sixth units)
                 :align-items      :center
                 :padding          (:half units)
                 :display          :flex
                 :font-size        (:subtitle-font units)
                 :font-family      (:title fonts)
                 :font-weight      500
                 :flex             1
                 :height (:one-and-half units)
                 :background-color (:light colors)
                 :color            (:night colors)}]]

   [edit-list
    [list--item
     [removable {:color (:medium colors)
                 :user-select :none}
      [hovered {:color (:primary colors)}]]]]

   [todo-list
    [list--item {:justify-content :flex-start}
     [hovered (:highlighted templates)]
     [selected (:selected templates)
      [hovered (:highlighted templates)]]

     [checkbox {:display          :flex
                :margin-right     (:two-third units)
                :width            (:two-third units)
                :height           (:two-third units)
                :background-color (:day colors)}]]]])
