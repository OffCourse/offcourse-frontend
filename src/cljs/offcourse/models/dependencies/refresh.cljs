(ns offcourse.models.dependencies.refresh
  (:require [offcourse.protocols.queryable :as qa]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :add-checkpoint [dependencies {:keys [checkpoint]}]
  (update-in dependencies [:course] #(qa/add % :checkpoint checkpoint)))

(defmethod refresh :delete-checkpoint [dependencies {:keys [checkpoint]}]
  (update-in dependencies [:course] #(qa/remove % :checkpoint checkpoint)))

(defmethod refresh :update-goal [dependencies {:keys [goal] :as query}]
  (update-in dependencies [:course] #(qa/refresh % :goal goal)))

(defmethod refresh :update-curator [{:keys [course] :as dependencies} {:keys [curator] :as query}]
  (if (and course curator)
    (update-in dependencies [:course] #(qa/refresh % :curator curator))
    dependencies))
