(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]))

(defmulti respond (fn [as {:keys [type]}] type))

(defmethod respond :checkpoint [as {:keys [course] :as query}]
  (ri/respond as :not-found-data {:type :course
                                  :course course}))

(defmethod respond :default [as query]
  (ri/respond as :not-found-data query))

(defmulti refresh
  (fn [_ {:keys [type]}]
    type))

(defmethod refresh :signed-in-user [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state (assoc proposal :queries #{}))
      (ri/respond as :refreshed-token {:type :token
                                       :token (:auth-token @state)}))))

(defmethod refresh :signed-out-user [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state (assoc proposal :queries #{}))
      (ri/respond as :refreshed-state :state @state))))

(defmethod refresh :refreshed-credentials [as {:keys [payload] :as query}]
  (when (:authenticated? payload)
    (ri/respond as :requested-profile {:type :profile})))

(defmethod refresh :found-profile [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state (assoc proposal :queries #{}))
      (when (va/valid? @state)
        (ri/respond as :refreshed-state :state @state)))))

(defmethod refresh :requested-view [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :viewmodel payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state (assoc proposal :queries #{}))
      (respond as payload)
      (when (va/valid? @state)
        (ri/respond as :refreshed-state :state @state)))))

(defmethod refresh :found-data [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :data payload)]
    (when (va/valid? proposal)
      (reset! state (assoc proposal :queries #{}))
      (ri/respond as :refreshed-state :state @state))))
