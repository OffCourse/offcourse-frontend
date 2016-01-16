(ns offcourse.adapters.fakedb.implementations.queryable
  (:require  [offcourse.fake-data.index :as fake-data]
             [clojure.set :as set])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch
  (fn [_ {:keys [type]}] type))

(defn create-fake-resource [resource-id]
  (-> fake-data/urls
      rand-nth
      fake-data/create-resource
      (assoc :resource-id resource-id)))

(defonce courses (take 5 (repeatedly fake-data/generate-course)))

(defmethod fetch :collection-names [_]
  (go
    {:tags (apply set/union (map :tags (flatten (map :checkpoints courses))))
     :curators (apply set/union (flatten (map :flags courses)))
     :flags (flatten (map :curator courses))}))

(defmethod fetch :course [_ {:keys [course-id]}]
  (go (some #(if (= (:course-id %) course-id) %) courses)))

(defmethod fetch :resource [_ {:keys [resource-id]}]
  (go (create-fake-resource resource-id)))

(defmethod fetch :resources [_ {:keys [resource-ids]}]
  (go (map create-fake-resource resource-ids)))
