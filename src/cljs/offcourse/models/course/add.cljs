(ns offcourse.models.course.add
  (:require [offcourse.models.checkpoint :as cp]
            [cuerdas.core :as str]
            [offcourse.protocols.queryable :as qa]))

(defn add [course {:keys [checkpoint] :as query}]
  (if (qa/get course query)
    course
    (let [checkpoint (-> checkpoint
                         cp/map->Checkpoint
                         (assoc
                          :checkpoint-id (-> course :checkpoints count)
                          :checkpoint-slug (str/slugify (:task checkpoint))
                          (cp/map->Checkpoint checkpoint)))]
      (update course :checkpoints
              #(conj % checkpoint)))))
