(ns offcourse.styles.modifiers
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden.selectors :as s]
            [offcourse.styles.classes :refer [checkbox hover list list--item]]))

(def removable (s/& (s/attr :data-remove := :true)))
(def selected (s/& (s/attr :data-selected := :true)))
(def hovered (s/& hover))
