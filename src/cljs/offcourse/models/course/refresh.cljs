(ns offcourse.models.course.refresh
  (:require [cuerdas.core :as str]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :curator [course {:keys [curator]}]
  (assoc course :curator curator))

(defmethod refresh :goal [course {:keys [goal]}]
  (assoc course
         :goal goal
         :course-slug (str/slugify goal)))
