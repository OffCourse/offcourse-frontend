(ns offcourse.appstate.queryable
  (:require [offcourse.models.appstate :as model]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri]))

(defn create-viewmodel [{:keys [type] :as proposed} store viewmodels]
  ((type viewmodels) proposed store))

(defn check [{:keys [state queries viewmodels] :as as} {:keys [datastore] :as query}]
  (if-not @state
    (qa/refresh as query)
    (if datastore
      (let [viewmodel (create-viewmodel (:view @state) datastore viewmodels)
            missing-data (va/missing-data viewmodel)]
        (if missing-data
          (ri/respond as :not-found-data missing-data)
          (ri/respond as :composed-viewmodel viewmodel)))
      (do
        (swap! queries #(conj % query))
        (when  (= (second @queries) query)
          ;; here we should remove the missing data from appstore
          (println "later error..."))
        as))))

(defn refresh [{:keys [state] :as as} query]
  (let [proposal (model/new query)]
    (reset! state proposal)
    (check as {:datastore (ds/new)})))

