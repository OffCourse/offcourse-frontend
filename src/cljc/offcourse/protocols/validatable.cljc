(ns offcourse.protocols.validatable)

(defprotocol Validatable
  (errors [this] [this type data])
  (errors-async [this])
  (valid? [this])
  (valid?-async [this]))

(defn unknown-field [errors]
  (-> errors
      keys
      first))
