(ns offcourse.protocols.validatable)

(defprotocol Validatable
  (errors [this] [this type data])
  (valid? [this]))
