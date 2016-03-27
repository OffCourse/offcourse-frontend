(ns offcourse.styles.components.form
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.selectors :as s]
            [offcourse.styles.modifiers :as m]
            [offcourse.styles.classes :as c]))

(defn form [{:keys [templates borders colors fonts units]}]

  [[:.form {:display         :flex
            :flex-direction  :row
            :justify-content :flex-end
            :flex            1}

    [:.btn {:font-size        (:full units)
            :justify-content :flex-end
            :margin-right     0
            :background-color (:day colors)}]

    [:.form--input {:text-align :right
                    :flex 7
                    :margin-right (:half units)}]]])
