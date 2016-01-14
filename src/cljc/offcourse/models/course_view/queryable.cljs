(ns offcourse.models.course-view.queryable
  (:require [medley.core :as medley]))

(defn refresh [{:keys [course] :as vm} {:keys [collections resources courses] :as store}]
  (let [labels     (medley/map-vals keys collections)
        course-id (:course-id course)
        course    (or (get courses course-id) course)
        resource-ids (->> (:checkpoints course)
                       (map (comp str :resource-id)))
        resources (or (map #(get resources %) resource-ids) resources)]
    (assoc vm :course course
           :labels labels
           :resources resources)))
