(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :appstate [{:keys [state proposal] :as as} {:keys [transaction] :as query}]
  (do
    (qa/refresh as :proposal transaction)
    (if (va/valid? as)
      (qa/refresh as :state {})
      (qa/add as :query query))))

(defmethod refresh :queries  [{:keys [state] :as as}]
  (swap! state #(assoc % :queries #{})))

(defmethod refresh :proposal  [{:keys [state proposal] :as as} query]
  ;; this should be done with a validator
  (when (qa/check as :permissions (qa/refresh @proposal (:proposal query)))
    (swap! proposal #(qa/refresh % (:proposal query)))))

(defmethod refresh :state  [{:keys [state proposal] :as as} _]
  (do
    (reset! state (assoc @proposal :queries #{}))
    (respond as :refreshed-state :state @state)))

(defmethod refresh :course [{:keys [state] :as as} {:keys [course] :as query}]
  (do
    (qa/refresh as :appstate query)
    (qa/refresh as :appstate (vh/home-view))))

(defmethod refresh :user [{:keys [state] :as as} {:keys [user] :as query}]
  (do
    (qa/refresh as :appstate query)
    (when (and (= (get-in @state [:viewmodel :type]) :new-user-view) (:user-name user))
      (qa/refresh as :appstate (vh/home-view)))))

(defmethod refresh :authenticated? [{:keys [state] :as as} {:keys [authenticated?] :as query}]
  (if authenticated?
    (respond as :requested-profile :profile {})
    (do
      (qa/refresh as :appstate (vh/home-view))
      (qa/refresh as :user {:name nil}))))

(defmethod refresh :profile [as {:keys [profile] :as query}]
  (if profile
    (respond as :requested-save :profile profile)
    (qa/refresh as :appstate {:type :new-user-view})))

(defmethod refresh :default [as query]
  (qa/refresh as :appstate query))
