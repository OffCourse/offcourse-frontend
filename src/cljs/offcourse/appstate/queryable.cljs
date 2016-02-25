(ns offcourse.appstate.queryable
  (:require [offcourse.models.appstate :as model]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri]))

(defn check [{:keys [state queries viewmodels] :as as} {:keys [store] :as query}]
  (if store
    (ri/respond as :checked-appstate {:state @state
                                      :store store})
    (do
      (swap! queries #(conj % query))
      (if  (= (second @queries) query)
        ;; here we should remove the defective state from appstore
        nil
        (do
          nil
          (ri/respond as :not-found-data query))))))

(defn refresh [{:keys [state queries] :as as} query]
  (let [proposal (model/new query)]
    (swap! queries #(conj % query))
    (reset! state proposal)
    (ri/respond as :refreshed-appstate {:state @state})))
