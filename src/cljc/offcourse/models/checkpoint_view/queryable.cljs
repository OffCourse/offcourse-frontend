(ns offcourse.models.checkpoint-view.queryable
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]))

(defn refresh [{:keys [course checkpoint-id] :as vm} {:keys [resources courses]}]
  (let [course     (or (get courses (:course-id course)) course)
        checkpoint (co/get-checkpoint course checkpoint-id)]
    (merge vm {:course        course
               :checkpoint-id checkpoint-id
               :labels        {:tags (lb/collection->labels (co/get-tags course))}
               :resource      (get resources (:resource-id checkpoint))})))
