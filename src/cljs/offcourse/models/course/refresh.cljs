(ns offcourse.models.course.refresh
  (:require [cuerdas.core :as str]
            [com.rpl.specter :refer [ALL transform select-first]]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :toggle-checkpoint [course {:keys [checkpoint]}]
  (let [checkpoint-id (:checkpoint-id checkpoint)]
    (transform [:checkpoints ALL #(= (:checkpoint-id %) checkpoint-id) :completed?]
               #(if % false (.now js/Date))
               course)))

(defmethod refresh :curator [course {:keys [curator]}]
  (assoc course :curator curator))

(defmethod refresh :goal [course {:keys [goal]}]
  (assoc course
         :goal (str/titleize goal)
         :course-slug (str/slugify goal)))
