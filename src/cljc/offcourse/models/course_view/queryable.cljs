(ns offcourse.models.course-view.queryable
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]))

(defn refresh [{:keys [course] :as vm} {:keys [courses resources]}]
  (let [course       (or (get courses (:course-id course)) course)
        tags         (co/get-tags course)
        resource-ids (co/get-resource-ids course)]
    (merge vm {:course    course
               :labels    {:tags (lb/collection->labels tags)}
               :resources (map #(get resources %) resource-ids)})))
