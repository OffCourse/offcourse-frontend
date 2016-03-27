(ns offcourse.styles.components.strip
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.selectors :as s]
            [offcourse.styles.modifiers :as m]
            [offcourse.styles.classes :as c]))

(defn strip [{:keys [templates borders colors fonts units]}]

  [c/strips (merge (:column-component templates)
                   {:padding-top (:full units)
                    :flex             1
                    :background-color (:light colors)
                    :padding-right    (:full units)})

   [c/strip (merge (:row-component templates)
                   (:sheet templates)
                   {:padding          (:full units)
                    :flex 1
                    :justify-content  :space-between
                    :align-items      :center})
     [m/hovered (:highlighted borders)]]

   [c/strip--section (merge (:column-component templates)
                            {:flex            9
                             :justify-content :space-between})
    [c/title (:title-font templates)]

    [m/first {:flex [[0 0 (:full units)]]
              :margin-right (:full units)}]
    [m/last {:flex 6
             :justify-content :flex-end}]
    [c/labels {:justify-content :flex-end}]]])
