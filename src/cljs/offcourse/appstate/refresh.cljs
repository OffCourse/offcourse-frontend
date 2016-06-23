(ns offcourse.appstate.refresh
  (:require [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.redirectable :as rd]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :requested-update [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (ri/respond as :refreshed-state :state @state))))

(defmethod refresh :requested-save-course [{:keys [state] :as as} _]
  (let [course (-> @state :viewmodel :new-course co/complete)
        proposal (qa/add @state :course course)]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (rd/redirect as :course course))))

(defmethod refresh :requested-save-user [{:keys [state] :as as} _]
  (let [user (-> @state :viewmodel :new-user)
        proposal (qa/add @state {:type :user-profile
                                 :user-profile user})]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (rd/redirect as :home))))

(defmethod refresh :fetched-auth-token [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [auth-token (:auth-token payload)
        proposal (qa/refresh @state :auth-token auth-token)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state proposal)
      (ri/respond as :not-found-data {:type :user-profile
                                      :auth-token auth-token}))))

(defmethod refresh :removed-auth-token [{:keys [state] :as as} _]
  (let [proposal (qa/refresh @state :auth-token (:auth-token nil))]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (rd/redirect as :home))))

(defmethod refresh :requested-view [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :viewmodel payload)]
    (if (qa/check as :permissions proposal)
      (do
        (reset! state proposal)
        (when-let [missing-data (va/missing-data @state payload)]
          (ri/respond as :not-found-data missing-data))
        (if (va/valid? @state)
          (ri/respond as :refreshed-state :state @state)
          (rd/redirect as :home)))
      (when (= (-> @state :viewmodel :type) :loading)
        (rd/redirect as :home)))))

(defmethod refresh :not-found-data [{:keys [state] :as as} {:keys [payload] :as query}]
  (when-not (-> @state :user :user-name)
    (rd/redirect as :signup)))

(defmethod refresh :found-data [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/add @state payload)]
    (when (va/valid? proposal)
      (reset! state proposal)
      (when-let [missing-data (va/missing-data @state payload)]
        (ri/respond as :not-found-data missing-data))
      (ri/respond as :refreshed-state :state @state))))
