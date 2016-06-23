(ns offcourse.models.appstate.missing-data
  (:require [offcourse.models.payload :as payload]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [clojure.set :as set]))

(defmulti missing-data (fn [state {:keys [type]}] type))

(defmethod missing-data :resources [state {:keys [resources] :as query}]
  (let [state-urls  (into #{} (map :url (:resources state)))
        query-urls (into #{} (map :url resources))
        missing-urls (set/difference query-urls state-urls)
        missing-resources (map (fn [url] {:url url}) missing-urls)]
    (when-not (empty? missing-resources)
      (payload/new :resources missing-resources))))

(defmethod missing-data :collection [state {:keys [collection] :as query}]
  (payload/new :collection collection))

(defmethod missing-data :course [state {:keys [course] :as query}]
  (if (:checkpoints course)
    (va/missing-data state (payload/new :resources (map (fn [url] {:url url}) (qa/get course :urls {}))))
    (payload/new :course course)))

(defmethod missing-data :checkpoint [state {:keys [course] :as query}]
  (payload/new :course course))

(defmethod missing-data :default [state query]
  nil)
