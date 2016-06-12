(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.course.index :as co]))

(defmulti respond (fn [as {:keys [type]}] type))

(defmethod respond :new-course [as query]
  nil)

(defmethod respond :checkpoint [as {:keys [course] :as query}]
  (ri/respond as :not-found-data {:type :course
                                  :course course}))

(defmethod respond :default [as query]
  (ri/respond as :not-found-data query))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :signed-in-user [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state proposal)
      (ri/respond as :refreshed-token {:type :token
                                       :token (:auth-token @state)}))))

(defmethod refresh :signed-out-user [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state proposal)
      (ri/respond as :refreshed-state :state @state))))

(defmethod refresh :requested-update [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (ri/respond as :refreshed-state :state @state))))

(defmethod refresh :requested-save [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [course (-> @state :viewmodel :new-course co/complete)
        proposal (qa/add @state :course course)]
    (when (qa/check as :permissions proposal)
      (reset! state proposal)
      (qa/refresh as {:type :requested-view
                      :payload (vh/course-view course)}))))

(defmethod refresh :refreshed-credentials [as {:keys [payload] :as query}]
  (when (:authenticated? payload)
    (ri/respond as :requested-profile {:type :profile})))

(defmethod refresh :found-profile [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state proposal)
      (when (va/valid? @state)
        (ri/respond as :refreshed-state :state @state)))))

(defmethod refresh :requested-view [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :viewmodel payload)]
    (if (qa/check as :permissions proposal)
      (do
        (reset! state proposal)
        (respond as payload)
        (when (va/valid? @state)
          (ri/respond as :refreshed-state :state @state)))
      (qa/refresh as {:type :requested-view
                      :payload (vh/home-view)}))))

(defmethod refresh :found-data [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :data payload)]
    (when (va/valid? proposal)
      (reset! state proposal)
      (ri/respond as :refreshed-state :state @state))))
