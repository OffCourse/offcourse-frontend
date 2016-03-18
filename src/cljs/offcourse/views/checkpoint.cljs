(ns offcourse.views.checkpoint
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn select-checkpoint [checkpoints selected-slug]
  (for [{:keys [checkpoint-slug] :as checkpoint} checkpoints]
    (if (= selected-slug checkpoint-slug)
      (with-meta checkpoint {:selected true})
      checkpoint)))

(defn augment-course [{:keys [checkpoints checkpoint-slug] :as course}]
  (let [tags (-> (qa/get course :tags {})
                 (lb/collection->labels checkpoint-slug))]
    (some-> course
            (assoc :checkpoints (select-checkpoint checkpoints checkpoint-slug))
            (with-meta {:tags tags}))))

(def graph
  {:checkpoint-slug (fnk [view-data]
                         (-> view-data :checkpoint :checkpoint-slug))
   :course-data   (fnk [view-data] (:course view-data))
   :course        (fnk [appstate course-data checkpoint-slug]
                       (if-let [course (-> appstate
                                           (qa/get :course course-data)
                                           (assoc :checkpoint-slug checkpoint-slug)
                                           augment-course)]
                         course
                         course-data))
   :url           (fnk [course checkpoint-slug]
                       (let [slug (if (= checkpoint-slug "index")
                                    (-> course
                                        :checkpoints
                                        first
                                        :checkpoint-slug)
                                    checkpoint-slug)]
                         (qa/get course :url slug)))
   :resource      (fnk [appstate url]
                       (qa/get appstate :resource {:url url}))
   :course-id     (fnk [course] (:course-id course))
   :actions (fnk [] {})
   :main          (fnk [resource [:components viewer]] (viewer resource))
   :dashboard     (fnk [url-helpers course [:components card dashboard]]
                       (dashboard {:main (card course url-helpers)}))})
