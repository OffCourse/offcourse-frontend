(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]))

(defn viewmodel-type [state]
  (-> state :viewmodel :type))

(defn check-permissions [state proposal]
  (let [old-type (viewmodel-type state)
        new-type(viewmodel-type proposal)
        user-name (-> proposal :user :name)]
    (cond
      (and (= old-type :new-user-view) (= new-type :new-user-view)) true
      (and (= old-type :new-user-view) user-name) true
      (= old-type :new-user-view) false
      :default true)))

(defn refresh-appstate [{:keys [state proposal] :as as} query]
  (when (check-permissions @state (qa/refresh @proposal query))
    (swap! proposal #(qa/refresh % query))
    (if (va/valid? as)
      (do
        (reset! state @proposal)
        (qa/refresh as {:type :queries})
        (respond as :refreshed-state :state @state))
      (when-let [missing-data (va/missing-data @proposal)]
        (qa/add as :query missing-data)
        (respond as :not-found-data missing-data)))))

(defmulti refresh
  (fn [_ {:keys [type] :as q}]
    type))

(defmethod refresh :queries  [{:keys [state] :as as}]
  (swap! state #(assoc % :queries #{})))


(defmethod refresh :course [{:keys [state] :as as} {:keys [course] :as query}]
  (do
    (refresh-appstate as query)
    (refresh-appstate as (vh/collection-view {:collection-type :flags
                                              :collection-name :featured}))))

(defmethod refresh :user [{:keys [state] :as as} {:keys [user] :as query}]
  (do
    (refresh-appstate as query)
    (when (and (= (get-in @state [:viewmodel :type]) :new-user-view) (:user-name user))
      (refresh-appstate as (vh/collection-view {:collection-type :flags
                                                :collection-name :featured})))))

(defmethod refresh :authenticated? [{:keys [state] :as as} {:keys [authenticated?] :as query}]
  (if authenticated?
    (do
      (respond as :requested-profile {:type :profile}))
    (do
      (refresh-appstate as (vh/collection-view {:collection-type :flags
                                                :collection-name :featured}))
      (qa/refresh as :user {:name nil}))))

(defmethod refresh :profile [as {:keys [profile] :as query}]
  (if profile
    (do
     (respond as :requested-save {:type :profile
                                 :profile profile}))
    (refresh-appstate as {:type :new-user-view})))

(defmethod refresh :default [as query]
  (refresh-appstate as query))
