(ns offcourse.appstate.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [clojure.set :as set]
            [offcourse.models.course.index :as co]))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :default [{:keys [state] :as as} query]
  (let [old-state @state]
    (swap! state #(qa/refresh % query))
    (when-not (= old-state @state)
      (if (va/valid? as)
        (do
          ;; move to refresh :queries
          (swap! state #(assoc % :queries #{}))
          (respond as :refreshed-state))
        (when-let [missing-data (va/missing-data @state)]
          ;; move to add :query
          (swap! state (fn [state] (update state :queries #(conj % (hash missing-data)))))
          (respond as :not-found-data missing-data))))))

(defn check [{:keys [queries state] :as as} query]
  (if (set/subset? queries #{(hash query)})
    (qa/refresh as {:type :loading-view})
    (respond as :not-found-data query)))
