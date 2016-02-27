(ns offcourse.appstate.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :appstate [{:keys [state] :as as} query]
  (let [old-state @state]
    (do
      (swap! state #(qa/refresh % query))
      (println @state)
      (when-not (= old-state @state)
        (println (va/valid? as))))))
