(ns offcourse.styles.vocabulary
  (:refer-clojure :exclude [first last list])
  (:require [garden.selectors :as s]))

;; LAYOUT
(s/defclass container)
(s/defclass layout)
(s/defclass layout--section)
(s/defclass main)
(s/defclass main--section)

;; ELEMENTS
(s/defclass list)
(def todo-list (list (s/attr :data-list-type := :todo)))
(def edit-list (list (s/attr :data-list-type := :edit)))
(s/defclass list--item)

(s/defclass strips)
(s/defclass strip)
(s/defclass strip--section)

(s/defclass cards)
(s/defclass card)
(s/defclass card--section)

(s/defclass viewer)
(s/defclass viewer--content)
(def viewer-header :h1)
(def viewer-text :p)

(s/defclass logo)

(s/defclass labels)
(s/defclass label)

;; this one must disappear
(s/defclass dashboard)

(s/defclass menubar)
(s/defclass menubar--section)

(s/defclass form)
(s/defclass form--input)

(s/defclass button)
(def understated-button (button (s/attr :data-button-type := :understated)))
(def textbar-button (button (s/attr :data-button-type := :textbar)))
(def icon-button (button (s/attr :data-button-type := :icon)))
(def checkbox-button (button (s/attr :data-button-type := :checkbox)))

(s/defclass title)
(s/defclass subtitle)

;; MODIFIERS
(s/defpseudoclass hover)
(s/defpseudoclass disabled)
(s/defpseudoclass first-child)
(s/defpseudoclass last-child)

(def selected (s/& (s/attr :data-selected := :true)))
(def disabled (s/& disabled))
(def hovered (s/& hover))
(def first (s/& first-child))
(def last (s/& last-child))
(def second (s/& (s/nth-child 2)))
(def third (s/& (s/nth-child 3)))
