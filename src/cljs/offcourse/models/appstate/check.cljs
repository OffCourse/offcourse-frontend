(ns offcourse.models.appstate.check
  (:require [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [schema.core :as schema]))

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

(defmethod check :course [{:keys [user] :as store} {:keys [course] :as query}]
  (let [{:keys [course-id curator]} course
        {:keys [name]} user]
    (if (or (and (= course-id :new) #_(= name curator))
            (qa/get store query))
      true
      false)))

(defmethod check :checkpoint [store query]
  (if (qa/get store query) true false))

(defmethod check :resources [{:keys [resources] :as ds} {:keys [urls] :as query}]
  (if (and resources (not (empty? resources)))
    (has-items? (map :url (qa/get ds query)) urls)
    false))

(defmethod check :resource [ds query]
  (if (qa/get ds query) true false))

(defmethod check :default [_ _]
  {:type :error
   :error :query-not-supported})

