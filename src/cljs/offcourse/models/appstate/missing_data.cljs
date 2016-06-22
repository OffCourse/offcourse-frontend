(ns offcourse.models.appstate.missing-data
  (:require [offcourse.protocols.queryable :as qa]))

(defmulti missing-data (fn [state {:keys [type]}] type))

(defmethod missing-data :collection [as query]
  query)

(defmethod missing-data :course [state {:keys [course] :as query}]
  (if (:checkpoints course)
    {:type :resources
     :resources (map (fn [url] {:url url}) (qa/get course :urls {}))}
    {:type :course
     :course course}))

(defmethod missing-data :checkpoint [state {:keys [course] :as query}]
  {:type :course
   :course course})

(defmethod missing-data :default [state query]
  nil)
