(ns offcourse.models.action)

(defrecord Action [type source payload])

(defn new [type source payload]
  (->Action type source payload))
