(ns offcourse.appstate.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :default [{:keys [state] :as as} query]
  (let [old-state @state]
    (swap! state #(qa/refresh % query))
    (when-not (= old-state @state)
      (if (va/valid? as)
        (respond as :refreshed-state {:state @state})
        (respond as :not-found-data (va/missing-data @state))))))
