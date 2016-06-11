(ns offcourse.models.course.add
  (:require [offcourse.models.checkpoint.index :as cp]
            [cuerdas.core :as str]
            [offcourse.protocols.queryable :as qa]))

(defn add [course {:keys [checkpoint] :as query}]
  (if (qa/get course query)
    course
    (let [checkpoint (-> checkpoint
                         (assoc :checkpoint-id (-> course :checkpoints count)
                                :completed? false
                                :checkpoint-slug (str/slugify (:task checkpoint))))]
      (update course :checkpoints #(if %
                                     (conj % (cp/map->Checkpoint checkpoint))
                                     (conj [] (cp/map->Checkpoint checkpoint)))))))
