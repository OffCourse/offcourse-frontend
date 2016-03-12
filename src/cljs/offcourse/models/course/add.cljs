(ns offcourse.models.course.add
  (:require [offcourse.models.checkpoint :as cp]))

(defn add [course {:keys [checkpoint]}]
  (let [checkpoint (assoc checkpoint :checkpoint-id (-> course :checkpoints count))]
    (update course :checkpoints
            #(conj % (cp/map->Checkpoint checkpoint)))))
