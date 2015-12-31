(ns offcourse.protocols.validatable)

(defprotocol Validatable
  (valid? [this]))
