(ns offcourse.styles.components.strip
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [offcourse.styles.vocabulary :as v]))

(defn strip [{:keys [templates borders colors fonts units]}]

  [v/strips (merge (:column-component templates)
                   {:padding-top (:full units)
                    :display :block
                    :flex             1
                    :background-color (:light colors)
                    :padding-right    (:full units)})

   [v/container
    [v/first {:border-bottom (:default borders)
              :border-width  (* 2 (:atom units))
              :margin-bottom (:two-third units)}]]

   [v/strip (merge (:row-component templates)
                   (:sheet templates)
                   {:padding          (:full units)
                    :flex 1
                    :justify-content  :center
                    :align-items      :flex-start})
    [v/hovered (:highlighted borders)]]

   [v/strip--section (merge (:column-component templates)
                            {:flex 2
                             :justify-content :center})
    [v/title (merge (:row-component templates)
                    (:recycled-paper templates)
                    (:title templates)
                    {:align-items     :center
                     :font-size       (:subtitle-font units)
                     :padding         (:half units)
                     :height          (:one-and-half units)})]

    [v/first {:flex [[0 0 (:one-and-half units)]]
              :margin-right (:sixth units)}]
    [v/second {:flex [[0 0 (:padded-column units)]]
              :margin-right (:full units)}]
    [v/third {:height (:one-and-half units)
              :margin-right (:full units)}]
    [v/last {:margin-right 0
             :justify-content :space-between}]
    [v/labels {:justify-content :flex-end
               :margin-bottom (:half units)}]]])
