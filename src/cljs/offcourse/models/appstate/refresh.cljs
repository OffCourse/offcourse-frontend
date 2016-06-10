(ns offcourse.models.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [com.rpl.specter :refer [transform]]
            [offcourse.models.appstate.paths :as paths]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :viewmodel [{:keys [user] :as state} {:keys [viewmodel] :as query}]
  (-> state (assoc :viewmodel viewmodel)))

(defmethod refresh :data [store {:keys [data] :as query}]
  (qa/add store data))

(defmethod refresh :token [state {:keys [token] :as query}]
  (-> state
      (assoc :auth-token token)
      (assoc :user {:user-name nil})))

(defmethod refresh :profile [state {:keys [user]}]
  (-> state (assoc :user user)))

(defmethod refresh :toggle-checkpoint [state {:keys [course] :as query}]
  (->> state (transform (paths/course course) #(qa/refresh % query))))

(defmethod refresh :default [state query]
  {:type :error :error :query-not-supported})
