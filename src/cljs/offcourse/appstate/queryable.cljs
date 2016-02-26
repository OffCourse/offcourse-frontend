(ns offcourse.appstate.queryable
  (:require [offcourse.models.appstate :as model]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri]))

(defn check [{:keys [state queries viewmodels] :as as} {:keys [store] :as query}]
  (swap! queries #(conj % query))
  (if store
    (do
      (reset! queries ())
      (ri/respond as :checked-appstate {:state @state
                                        :store store}))
    (if (< (count @queries) 5)
      (if (= (second @queries) query)
        (println "double" query)
        (ri/respond as :not-found-data query))
      (do
        (reset! queries ())
        (ri/respond as :crashed nil)))))

(defn refresh [{:keys [state queries] :as as} query]
  (println query)
  (let [proposal (model/new query)]
    (swap! queries #(conj % query))
    (reset! state proposal)
    (ri/respond as :refreshed-appstate {:state @state})))
