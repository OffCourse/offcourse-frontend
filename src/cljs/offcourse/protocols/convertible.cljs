(ns offcourse.protocols.convertible
  (:require [offcourse.helpers.converters :as cv]
            [offcourse.models.course.index :refer [Course]]))

(defprotocol Convertible
  (to-js [this])
  (to-url [this routes])
  (to-json [this])
  (to-collection [this])
  (to-resource [this])
  (to-course [this]))

(extend-protocol Convertible
  PersistentArrayMap
  (to-collection [this] (cv/to-collection this))
  (to-resource [this] (cv/to-resource this))
  PersistentHashMap
  (to-collection [this] (cv/to-collection this))
  (to-course [this] (cv/to-course this))
  Course
  (to-js [this] (clj->js this)))
