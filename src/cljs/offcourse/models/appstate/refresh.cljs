(ns offcourse.models.appstate.refresh
  (:require [com.rpl.specter :refer [select-first setval transform]]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.models.checkpoint.index :as cp]
            [offcourse.protocols.queryable :as qa]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :viewmodel [state {:keys [viewmodel] :as query}]
  (-> state (assoc :viewmodel viewmodel)))

(defmethod refresh :data [state {:keys [data]}]
  (qa/add state data))

(defmethod refresh :auth-token [state {:keys [auth-token] :as q}]
  (-> state
      (assoc :auth-token auth-token)
      (assoc :user {:user-name nil})))

(defmethod refresh :toggle-checkpoint [state {:keys [course] :as query}]
  (->> state (transform (paths/course course) #(qa/refresh % query))))

(defmethod refresh :update-goal [{:keys [viewmodel] :as state} {:keys [goal] :as query}]
  (->> state (transform (paths/new-course) #(qa/refresh % :goal goal))))

(defmethod refresh :update-user-name [{:keys [viewmodel] :as state} {:keys [user-name] :as query}]
  (->> state (transform (paths/new-user) #(qa/refresh % :user-name user-name))))

(defmethod refresh :add-checkpoint [{:keys [viewmodel] :as state} {:keys [checkpoint] :as query}]
  (->> state (transform (paths/new-course) #(qa/add % :checkpoint checkpoint))))

(defmethod refresh :update-tag [{:keys [viewmodel] :as state} {:keys [tag] :as query}]
  (->> state (setval (paths/new-tag) tag)))

(defmethod refresh :add-tag [{:keys [viewmodel] :as state} _]
  (let [tag (->> state (select-first (paths/new-tag)))]
    (->> state
         (transform (paths/new-checkpoint) #(qa/add % :tag tag))
         (setval (paths/new-tag) nil))))

(defmethod refresh :add-new-checkpoint [{:keys [viewmodel] :as state} _]
  (let [checkpoint (select-first (paths/new-checkpoint) state)]
    (->> state
         (transform (paths/new-course) #(qa/add % :checkpoint checkpoint))
         (transform (paths/new-checkpoint) #(cp/new)))))

(defmethod refresh :remove-checkpoint [{:keys [viewmodel] :as state} {:keys [checkpoint] :as query}]
  (->> state (transform (paths/new-course) #(qa/remove % :checkpoint checkpoint))))

(defmethod refresh :update-task [{:keys [viewmodel] :as state} {:keys [task] :as query}]
  (->> state (transform (paths/new-checkpoint) #(qa/refresh % :task task))))

(defmethod refresh :update-url [{:keys [viewmodel] :as state} {:keys [url] :as query}]
  (->> state (transform (paths/new-checkpoint) #(qa/refresh % :url url))))

(defmethod refresh :default [state query]
  {:type :error
   :error :query-not-supported})
