(ns offcourse.models.dependencies.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.checkpoint.index :as cp]
            [cuerdas.core :as str]
            [offcourse.models.profile.index :as pf]
            [offcourse.protocols.validatable :as va]))

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
  (assoc-in dependencies [:checkpoint] (cp/new)))

(defmethod refresh :reset-tag [dependencies]
  (assoc-in dependencies [:tag] nil))

(defmethod refresh :update-tag [dependencies {:keys [tag] :as query}]
  (assoc-in dependencies [:tag] tag))

(defmethod refresh :add-tag [dependencies {:keys [tag] :as q}]
  (update-in dependencies [:checkpoint] #(qa/add % :tag tag)))

(defmethod refresh :update-user-name [{:keys [profile] :as dependencies} {:keys [user-name] :as q}]
  (if profile
    (update-in dependencies [:profile] #(qa/refresh % :user-name user-name))
    (assoc dependencies :profile (pf/new {:user-name user-name}))))

