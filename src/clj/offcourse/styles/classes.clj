(ns offcourse.styles.classes
  (:refer-clojure :exclude [+ - * / list])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [percent px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(s/defclass list)
(s/defclass label)
(s/defclass btn)
(s/defclass list--item)
(s/defclass checkbox)
(s/defclass title)
(s/defclass subtitle)
(s/defclass strips)
(s/defclass strip)
(s/defclass strip--section)
(s/defclass labels)
(s/defclass card)
(s/defclass container)
(s/defclass card--section)
(s/defclass cards)
