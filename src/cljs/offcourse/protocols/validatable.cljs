(ns offcourse.protocols.validatable)

(defprotocol Validatable
  (missing-data [this])
  (errors [this])
  (valid? [this]))
