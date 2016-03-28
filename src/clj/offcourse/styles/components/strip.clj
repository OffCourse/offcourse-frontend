(ns offcourse.styles.components.strip
  (:require [offcourse.styles.vocabulary :as v]))

(defn strip [{:keys [templates borders colors fonts units]}]

  [v/strips (merge (:column-component templates)
                   {:padding-top (:full units)
                    :flex             1
                    :background-color (:light colors)
                    :padding-right    (:full units)})

   [v/strip (merge (:row-component templates)
                   (:sheet templates)
                   {:padding          (:full units)
                    :flex 1
                    :justify-content  :space-between
                    :align-items      :center})
     [v/hovered (:highlighted borders)]]

   [v/strip--section (merge (:column-component templates)
                            {:flex            9
                             :justify-content :space-between})
    [v/title (:title-font templates)]

    [v/first {:flex [[0 0 (:full units)]]
              :margin-right (:full units)}]
    [v/last {:flex 6
             :justify-content :flex-end}]
    [v/labels {:justify-content :flex-end}]]])
