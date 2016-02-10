(ns offcourse.appstate.queryable
  (:require [offcourse.appstate.appstore :as appstore]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri]
            [offcourse.views.app :refer [app]]))

(defmulti refresh (fn [{:keys [type]} {:keys [type]}] (if type :query :store)))

(defmethod refresh :query [{:keys [proposed] :as as} query]
  (let [proposal (appstore/new query)]
    (reset! proposed proposal)
    (refresh as)))

(defmethod refresh :store
  ([as] (refresh as {:store (ds/new)}))
  ([{:keys [proposed viewmodels] :as as} {:keys [store]}]
   (let [{:keys [type] :as proposed} (:view @proposed)
         viewmodel ((type viewmodels) proposed store)
         missing-data (va/missing-data viewmodel)]
     (if missing-data
       (ri/respond as :not-found-data missing-data)
       (ri/respond as :composed-viewmodel {:data viewmodel
                                           :view-component app})))))
