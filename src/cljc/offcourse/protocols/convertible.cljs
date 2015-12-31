(ns offcourse.protocols.convertible)

(defprotocol Convertible
  (to-js [this])
  (to-json [this]))
