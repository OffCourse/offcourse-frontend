(ns offcourse.models.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [com.rpl.specter :refer [transform]]
            [offcourse.models.appstate.paths :as paths]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :viewmodel [state {:keys [viewmodel]}]
  (-> state (assoc :viewmodel viewmodel)))

(defmethod refresh :data [state {:keys [data]}]
  (qa/add state data))

(defmethod refresh :token [state {:keys [token]}]
  (-> state
      (assoc :auth-token token)
      (assoc :user {:user-name nil})))

(defmethod refresh :profile [state {:keys [user]}]
  (-> state (assoc :user user)))

(defmethod refresh :toggle-checkpoint [state {:keys [course] :as query}]
  (->> state (transform (paths/course course) #(qa/refresh % query))))

(defmethod refresh :update-goal [{:keys [viewmodel] :as state} {:keys [goal] :as query}]
  (->> state (transform (paths/new-course) #(qa/refresh % :goal goal))))

(defmethod refresh :default [state query]
  {:type :error :error :query-not-supported})
