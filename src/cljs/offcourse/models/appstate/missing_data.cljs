(ns offcourse.models.appstate.missing-data
  (:require [offcourse.models.course :as co]
            [offcourse.protocols.queryable :as qa]))

(defmulti missing-data
  (fn [{:keys [view-type]} type] view-type))

(defmethod missing-data :collection-view [{:keys [view-data collection] :as as} data-type]
  (if-let [data-present? (qa/check as data-type (data-type view-data))]
    (let [collection (qa/get as :collection (:collection view-data))
          course-ids (:course-ids collection)
          query {:type :courses
                 :course-ids course-ids}]
      (when-not (qa/check as query) query))
    view-data))

(defmethod missing-data :checkpoint-view [{:keys [view-data collection] :as as} data-type]
  (if-let [data-present? (qa/check as data-type (data-type view-data))]
    (let [course       (qa/get as :course (:course view-data))
          resource-ids (co/get-resource-ids course)
          query        {:type :resources
                        :resource-ids resource-ids}]
      (when-not (or (qa/check as query) (empty? resource-ids))
        query))
    view-data))

(defmethod missing-data :new-course-view [{:keys [resources] :as as} data-type]
  (when (< (count resources) 5) {:type :resources
                                  :resource-ids :featured}))

(defmethod missing-data :default [as type]
  {:type :error
   :error :appstate-empty})
