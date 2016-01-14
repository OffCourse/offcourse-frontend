(ns offcourse.models.course-view.validatable
  (:require [offcourse.protocols.queryable :as qa]))

(defn missing-data [{:keys [course] :as vm}]
  (let [{:keys [course-id]} course
        next-missing-field (first (keys (qa/check vm)))
        resource-ids (->> (:checkpoints course)
                          (map (comp str :resource-id)))
        payload {:type next-missing-field}]
    (case next-missing-field
      :labels (assoc payload :type :collection-names)
      :course (assoc payload :course-id course-id)
      :resources (assoc payload :resource-ids resource-ids)
      nil)))
