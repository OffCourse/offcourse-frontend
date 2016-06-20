(ns offcourse.protocols.convertible
  (:require [offcourse.helpers.converters :as cv]
            [offcourse.models.course.index :refer [Course]]))

(defprotocol Convertible
  (to-js [this])
  (to-url [this routes])
  (to-json [this])
  (to-collection [this])
  (to-resource [this])
  (to-user-profile [this])
  (to-course [this]))

(extend-protocol Convertible
  PersistentArrayMap
  (to-url [this routes] (cv/to-url this routes))
  (to-collection [this] (cv/to-collection this))
  (to-user-profile [this] (cv/to-user-profile this))
  (to-resource [this] (cv/to-resource this))
  PersistentHashMap
  (to-collection [this] (cv/to-collection this))
  (to-course [this] (cv/to-course this))
  (to-user-profile [this] (cv/to-user-profile this))
  (to-resource [this] (cv/to-resource this))
  Course
  (to-js [this] (clj->js this)))
