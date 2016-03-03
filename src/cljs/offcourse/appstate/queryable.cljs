(ns offcourse.appstate.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [clojure.set :as set]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :default [{:keys [state] :as as} query]
  (let [old-state @state]
    (swap! state #(qa/refresh % query))
    (when-not (= old-state @state)
      (if (va/valid? as)
        (do
          (swap! state (fn [state] (assoc state :queries #{})))
          (respond as :refreshed-state {:state @state}))
        (when-let [missing-data (va/missing-data @state)]
          (swap! state (fn [state] (update state :queries #(conj % (hash missing-data)))))
          (respond as :not-found-data missing-data))))))

(def retries (atom 0))

(defn check [{:keys [queries state] :as as} query]
  (if (set/subset? queries #{(hash query)})
    (qa/refresh as {:type :appstate
                    :appstate {:view-type :loading-view
                               :view-data {}}})
    (do
      (println "--------")
      (println  (hash query))
      (swap! state (fn [state] (update state :queries #(conj % (hash query)))))
      (println "QS" (:queries @state))
      (when (< @retries 10)
        (swap! retries inc)
        (respond as :not-found-data query)))))
