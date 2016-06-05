(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh
  (fn [_ {:keys [type]}]
    type))

(defmethod refresh :requested-view [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :viewmodel payload)]
    (when (and (qa/check as :permissions proposal) )
      (reset! state (assoc proposal :queries #{}))
      (ri/respond as :not-found-data payload)
      (when (va/valid? @state)
        (ri/respond as :refreshed-state :state @state)))))

(defmethod refresh :found-data [{:keys [state] :as as} {:keys [payload] :as query}]
  (let [proposal (qa/refresh @state :data payload)]
    (if (va/valid? proposal)
      (do
        (reset! state (assoc proposal :queries #{}))
        (ri/respond as :refreshed-state :state @state)))))
