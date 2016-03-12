(ns offcourse.views.checkpoint
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn select-checkpoint [checkpoints selected-id]
  (for [{:keys [checkpoint-id] :as checkpoint} checkpoints]
    (if (= selected-id checkpoint-id)
      (with-meta checkpoint {:selected true})
      checkpoint)))

(defn augment-course [{:keys [checkpoints checkpoint-id] :as course}]
  (let [tags (-> (qa/get course :tags {})
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
   :url           (fnk [course checkpoint-id]
                       (qa/get course :url checkpoint-id))
   :resource      (fnk [appstate url]
                       (qa/get appstate :resource {:url url}))
   :course-id     (fnk [course] (:course-id course))
   :main          (fnk [resource [:components viewer]] (viewer resource))
   :dashboard     (fnk [url-helpers course [:components card dashboard]]
                       (dashboard {:main (card course url-helpers)}))})
