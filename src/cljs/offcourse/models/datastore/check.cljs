(ns offcourse.models.datastore.check
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [offcourse.protocols.queryable :as qa]))

(defn has-items? [collection-ids query-ids]
  (set/superset? (into #{} collection-ids) (into #{} query-ids)))

(defmulti check (fn [_ {:keys [type]}] type))

(defmethod check :collection-names [{:keys [has-collection-names?]} query]
  has-collection-names?)

(defmethod check :collection [ds query]
  (when-let [course-ids (:course-ids (qa/get ds query))]
    (> (count course-ids) 0)))

(defmethod check :courses [{:keys [courses] :as ds} {:keys [course-ids] :as query}]
  (when courses (has-items? (map :course-id (qa/get ds query)) course-ids)))

(defmethod check :course [store query]
  (if (qa/get store query) true false))

(defmethod check :resources [{:keys [resources]} {:keys [resource-ids]}]
  (when resource-ids (has-items? (keys resources) resource-ids)))

(defmethod check :resource [{:keys [resources]} {:keys [resource]}]
  (when-let [{:keys [resource-id]} resource]
    (has-items? (keys resources) [resource-id])))

(defmethod check :default [{:keys [resources]} {:keys [resource-id]}]
  {:type :error
   :error :query-not-supported})
