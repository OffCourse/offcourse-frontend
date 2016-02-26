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
    (ri/respond as :not-found-data query)))

(defn refresh [{:keys [state queries] :as as} query]
  (let [proposal (model/new query)]
    (reset! queries '(query))
    (reset! state proposal)
    (ri/respond as :refreshed-appstate {:state @state})))
