(ns offcourse.protocol-extensions.loggable
  (:require [shared.protocols.loggable :as log :refer [Loggable]]))

(extend-protocol Loggable
  string
  (-log
    ([this] (.log js/console this))
    ([this args-array] (.log js/console this (into [] args-array))))
  (-error
    ([this] (.error js/console this)))
  object
  (-log
    ([this] (.log js/console this))
    ([this args-array] (.log js/console this (into [] args-array))))
  (-error
    ([this] (.error js/console this))))
