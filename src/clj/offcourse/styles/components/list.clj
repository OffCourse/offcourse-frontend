(ns offcourse.styles.components.list
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden.selectors :as s]
            [offcourse.styles.modifiers :refer [removable selected hovered]]
            [offcourse.styles.classes :refer [checkbox hover list list--item]]))

(def todo-list (list (s/attr :data-list-type := :todo)))
(def edit-list (list (s/attr :data-list-type := :edit)))
(def checkpoint-list (list (s/attr :data-list-type := :checkpoint)))

(defn list-component [{:keys [templates borders colors fonts units]}]

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

   ;; refactor to strips
   [checkpoint-list {:padding-top (:full units)
                     :background-color (:light colors)
                     :padding-right    (:full units)}

    [list--item    {:padding          (:full units)
                    :border-bottom    (:default borders)
                    :min-height       (:five units)
                    :justify-content  :space-between
                    :margin-bottom    (:two-third units)
                    :background-color (:day colors)}
     [hovered (:highlighted borders)]]

    [:.info   {:flex            [[9]]
               :justify-content :space-between
               :flex-direction  :column}]
    [:.tags   {:flex            [[6]]
               :display         :flex
               :flex-direction  :column
               :justify-content :flex-end}
     [:.labels {:display         :flex
                :margin-bottom   (:full units)
                :justify-content :flex-end
                :flex-wrap       :wrap}]]

    [:.tag--input {:display         :flex
                   :flex-direction  :row
                   :justify-content :flex-end
                   :flex            1}

     [:.btn {:font-size        (:full units)
             :justify-content :flex-end
             :margin-right     0
             :background-color (:day colors)}]

     [:.subtitle {:text-align :right
                  :flex 7
                  :margin-right (:half units)}]]]

   [edit-list
    [list--item
     [:.btn--remove
      [removable {:color (:medium colors)
                  :user-select :none}
       [hovered {:color (:primary colors)}]]]]]

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
