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

;; this needs to be a multimethod
(defn add [{:keys [state] :as as} query]
  ;; move to view-model-get (return course if valid otherwise nil)
  (let [course (-> (:viewmodel @state)
                   (qa/get query)
                   co/complete)]
    (if (va/valid? course)
      (qa/refresh as :course course)
      (.alert js/window "not saved..."))))

