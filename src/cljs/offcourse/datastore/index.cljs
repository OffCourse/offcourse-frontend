(ns offcourse.datastore.index
  (:require [clojure.set :as set]
            [com.stuartsierra.component :as component]
            [offcourse.datastore.models.store :as model]
            [offcourse.protocols.queryable :refer [check refresh Queryable]]
            [offcourse.protocols.responsive :as ri]))

(defrecord Datastore [component-name input-channel output-channel actions]
  component/Lifecycle
  (start [ds]
    (let [ds (assoc ds :store (atom (model/new-store)))]
      (assoc ds :listener (ri/listen ds))))
  (stop  [ds] (dissoc ds :store))
  Queryable
  (check [{:keys [store] :as ds} query]
    (if-let [course-present? (check @store query)]
      (ri/respond ds :checked-store {:store @store})
      (ri/respond ds :not-found-data query)))
  (refresh [{:keys [store] :as ds} query]
    (swap! store #(refresh % query))
    (ri/respond ds :refreshed-datastore {:store @store})))

(defn new-datastore []
  (map->Datastore {:component-name :datastore}))
