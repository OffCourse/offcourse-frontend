(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.validatable :as va]))

(defn refresh-appstate [{:keys [state] :as as} query]
  (let [old-state @state]
    (swap! state #(qa/refresh % query))
    (when-not (= old-state @state)
      (if (va/valid? as)
        (do
          (qa/refresh as {:type :queries})
          (respond as :refreshed-state))
        (when-let [missing-data (va/missing-data @state)]
          (qa/add as :query missing-data)
          (respond as :not-found-data missing-data))))))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :queries  [{:keys [state] :as as}]
  (swap! state #(assoc % :queries #{})))

(defmethod refresh :authenticated? [{:keys [state] :as as} {:keys [authenticated?] :as query}]
  (if authenticated?
    (respond as :requested-profile {:type :profile})
    (qa/refresh as :user {:name nil})))

(defmethod refresh :profile [as {:keys [profile] :as query}]
  (if profile
    (respond as :requested-save {:type :profile
                                 :profile profile})
    (refresh-appstate as query)))

(defmethod refresh :default [as query]
  (refresh-appstate as query))
