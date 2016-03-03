(ns offcourse.protocols.validatable)

(defprotocol Validatable
  (-missing-data [this])
  (errors [this])
  (-valid? [this]))

(defn valid? [this] (-valid? this))

(defn missing-data [this] (-missing-data this))
