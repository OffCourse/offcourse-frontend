(ns offcourse.protocols.convertible)

(defprotocol Convertible
  (to-url [this routes])
  (to-user-profile [this])
  (to-courses [this])
  (to-course [this])
  (to-resources [this]))
