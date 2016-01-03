(ns offcourse.protocols.convertible
  (:require [offcourse.helpers.converters :as cv]
            [offcourse.models.course :as co :refer [Course]]))

(defprotocol Convertible
  (to-js [this])
  (to-json [this])
  (to-collection [this])
  (to-course [this]))

(extend-protocol Convertible
  PersistentArrayMap
  (to-collection [this] (cv/to-collection this))
  PersistentHashMap
  (to-course [this] (cv/to-course this))
  Course
  (to-js [this]
    (clj->js this)))
