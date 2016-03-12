(ns offcourse.models.course.add
  (:require [offcourse.models.checkpoint :as cp]
            [cuerdas.core :as str]))

(defn add [course {:keys [checkpoint]}]
  (let [checkpoint (assoc checkpoint
                          :checkpoint-id (-> course :checkpoints count)
                          :checkpoint-slug (str/slugify (:task checkpoint)))]
    (update course :checkpoints
            #(conj % (cp/map->Checkpoint checkpoint)))))
