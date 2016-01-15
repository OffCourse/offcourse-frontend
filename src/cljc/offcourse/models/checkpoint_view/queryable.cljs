(ns offcourse.models.checkpoint-view.queryable
  (:require [medley.core :as medley]))

(defn refresh [{:keys [course checkpoint-id] :as vm}
               {:keys [collections resources courses] :as store}]
  (let [labels     (medley/map-vals keys collections)
        course-id (:course-id course)
        course    (or (get courses course-id) course)
        resource (->> (:checkpoints course)
                      (some #(if (= (:checkpoint-id %) checkpoint-id) %))
                      :resource-id
                      (get resources))]
    (assoc vm :course course
           :checkpoint-id checkpoint-id
           :labels labels
           :resource resource)))
