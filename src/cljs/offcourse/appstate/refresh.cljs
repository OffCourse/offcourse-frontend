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
