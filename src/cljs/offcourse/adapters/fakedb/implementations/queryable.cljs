(ns offcourse.adapters.fakedb.implementations.queryable
  (:require  [offcourse.fake-data.index :as fake-data])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch
  (fn [_ {:keys [type]}] type))

(defn create-fake-resource [resource-id]
  (-> fake-data/urls
      rand-nth
      fake-data/create-resource
      (assoc :resource-id resource-id)))

(defmethod fetch :resource [_ {:keys [resource]}]
  (go
    (create-fake-resource (:resource-id resource))))

(defmethod fetch :resources [_ {:keys [resource-ids]}]
  (go
    (map create-fake-resource resource-ids)))
