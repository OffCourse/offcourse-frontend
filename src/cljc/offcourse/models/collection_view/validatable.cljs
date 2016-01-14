(ns offcourse.models.collection-view.validatable
  (:require [offcourse.protocols.queryable :as qa]))

(defn missing-data [{:keys [collection] :as vm}]
  (let [{:keys [collection-name collection-type course-ids]} collection
        next-missing-field (first (keys (qa/check vm)))
        payload {:type next-missing-field}]
    (case next-missing-field
      :labels     (assoc payload :type :collection-names)
      :collection (assoc payload :collection-name collection-name
                         :collection-type collection-type)
      :courses    (assoc payload :course-ids course-ids)
      nil)))
