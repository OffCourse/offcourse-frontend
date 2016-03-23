(ns offcourse.models.dependencies.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.checkpoint.index :as cp]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :add-checkpoint [dependencies {:keys [checkpoint] :as query}]
  (update-in dependencies [:course] #(qa/add % :checkpoint checkpoint)))

(defmethod refresh :delete-checkpoint [dependencies {:keys [checkpoint]}]
  (update-in dependencies [:course] #(qa/remove % :checkpoint checkpoint)))

(defmethod refresh :update-goal [dependencies {:keys [goal] :as query}]
  (update-in dependencies [:course] #(qa/refresh % :goal goal)))

(defmethod refresh :update-curator [{:keys [course] :as dependencies} {:keys [curator] :as query}]
  (if (and course curator (not (:curator course)))
    (update-in dependencies [:course] #(qa/refresh % :curator curator))
    dependencies))

(defmethod refresh :update-url [dependencies {:keys [url] :as query}]
  (update-in dependencies [:checkpoint] #(qa/refresh % :url url)))

(defmethod refresh :update-task [dependencies {:keys [task] :as query}]
  (update-in dependencies [:checkpoint] #(qa/refresh % :task task)))

(defmethod refresh :reset-checkpoint [dependencies]
  (assoc-in dependencies [:checkpoint] (cp/new {:tags #{}})))
