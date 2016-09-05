(ns offcourse.appstate.react
  (:require [offcourse.appstate.check :as ck]
            [shared.protocols.actionable :as ac]
            [shared.protocols.loggable :as log]
            [shared.protocols.queryable :as qa]
            [shared.protocols.responsive :as ri]
            [shared.protocols.validatable :as va]))

(defmulti react (fn [_ event]
                  (va/resolve-type event)))

(defmethod react [:granted :credentials] [{:keys [state] :as as} [_ payload]]
  (let [auth-token (:auth-token payload)
        proposal (ac/perform @state [:update payload])]
    (when (ck/check as proposal)
      (reset! state proposal)
      (ri/respond as [:not-found {:user-profile nil}]))))

(defmethod react [:requested :viewmodel] [{:keys [state] :as as} [_ payload]]
  (let [{:keys [viewmodel] :as proposal} (ac/perform @state [:update payload])]
    (when (ck/check as proposal)
      (reset! state proposal)
      (when-let [missing-data (qa/missing-data @state viewmodel)]
        (ri/respond as [:not-found missing-data]))
      (if (va/valid? @state)
        (ri/respond as [:refreshed @state])
        (log/error @state (va/errors @state))))))

(defmethod react [:requested :sign-in] [{:keys [state] :as as} [_ action]]
  (ri/respond as [:requested action]))

(defmethod react [:requested :actions] [{:keys [state] :as as} [_ action]]
  (let [proposal (ac/perform @state action)]
    (when (va/valid? proposal)
      (reset! state proposal)
      (ri/respond as [:updated @state]))))

(defmethod react [:found :data] [{:keys [state] :as as} [_ payload]]
  (let [proposal (ac/perform @state [:add payload])]
    (when (va/valid? proposal)
      (reset! state proposal)
      (ri/respond as [:refreshed @state]))))

(defmethod react [:not-found :data] [{:keys [state] :as as} [_ payload]]
  (log/error payload "missing-data")
  #_(when-not (-> @state :user :user-name)
      (rd/redirect as :signup)))
