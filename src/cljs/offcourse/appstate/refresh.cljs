(ns offcourse.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :queries  [{:keys [state] :as as}]
  (swap! state #(assoc % :queries #{})))

(defmethod refresh :default [{:keys [state] :as as} query]
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
