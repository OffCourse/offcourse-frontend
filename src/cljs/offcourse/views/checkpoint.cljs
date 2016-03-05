(ns offcourse.views.checkpoint
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn select-checkpoint [checkpoints selected-id]
  (for [{:keys [checkpoint-id] :as checkpoint} checkpoints]
    (if (= selected-id checkpoint-id)
      (with-meta checkpoint {:selected true})
      checkpoint)))

(defn augment-course [{:keys [checkpoints checkpoint-id] :as course}]
  (let [tags (-> (co/get-tags course)
                 (lb/collection->labels checkpoint-id))]
    (some-> course
            (assoc :checkpoints (select-checkpoint checkpoints checkpoint-id))
            (with-meta {:tags tags}))))

(def graph
  {:checkpoint-id (fnk [view-data] (:checkpoint view-data))
   :course-data   (fnk [view-data] (:course view-data))
   :course        (fnk [appstate course-data checkpoint-id]
                       (if-let [course (-> appstate
                                           (qa/get :course course-data)
                                           (assoc :checkpoint-id checkpoint-id)
                                           augment-course)]
                         course
                         course-data))
   :resource-id   (fnk [course checkpoint-id]
                       (co/get-resource-id course checkpoint-id))
   :resource      (fnk [appstate resource-id]
                       (qa/get appstate :resource {:resource-id resource-id}))
   :course-id     (fnk [course] (:course-id course))
   :main          (fnk [resource [:components viewer]] (viewer resource))
   :dashboard     (fnk [url-helpers course [:components card dashboard]]
                       (dashboard {:main (card course url-helpers)}))})
