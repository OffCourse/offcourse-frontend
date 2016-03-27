(ns offcourse.styles.modifiers
  (:refer-clojure :exclude [first last list])
  (:require [garden.selectors :as s]))

(s/defpseudoclass hover)
(s/defpseudoclass first-child)
(s/defpseudoclass last-child)

(def removable (s/& (s/attr :data-remove := :true)))
(def selected (s/& (s/attr :data-selected := :true)))
(def hovered (s/& hover))
(def first (s/& first-child))
(def last (s/& last-child))
