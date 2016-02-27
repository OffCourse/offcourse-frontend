(ns offcourse.models.datastore.check
  (:require [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [schema.core :as schema]
            [offcourse.models.appstate :refer [Appstate]]))

(defn has-items? [collection-ids query-ids]
  (set/superset? (into #{} collection-ids) (into #{} query-ids)))

(defmulti check
  (fn [_ {:keys [type] :as query}]
    (if query type :store)))

(defmethod check :collection-names [ds query]
  (if (qa/get ds query) true false))

(defmethod check :collection [ds query]
  (if (qa/get ds query) true false))

(defmethod check :courses [{:keys [courses] :as ds} {:keys [course-ids] :as query}]
  (if (and courses (not (empty? courses)))
    (has-items? (map :course-id (qa/get ds query)) course-ids)
    false))

(defmethod check :course [store query]
  (if (qa/get store query) true false))

(defmethod check :checkpoint [store query]
  (if (qa/get store query) true false))

(defmethod check :resources [{:keys [resources] :as ds} {:keys [resource-ids] :as query}]
  (if (and resources (not (empty? resources)))
    (has-items? (map :resource-id (qa/get ds query)) resource-ids)
    false))

(defmethod check :resource [ds query]
  (if (qa/get ds query) true false))

(defmethod check :default [_ _]
  {:type :error
   :error :query-not-supported})
