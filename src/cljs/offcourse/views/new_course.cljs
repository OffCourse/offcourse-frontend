(ns offcourse.views.new-course
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn augment-course [{:keys [checkpoints] :as course}]
  (let [tags (-> (co/get-tags course)
                 (lb/collection->labels 0))]
    (some-> course
            (with-meta {:tags tags}))))

(def graph
  {:course-data (fnk [view-data] (:course view-data))
   :course        (fnk [appstate course-data]
                       (if-let [course (-> course-data
                                           augment-course)]
                         course
                         course-data))
   :main        (fnk [appstate handlers [:components resource-list] url-helpers]
                     (resource-list (:resources appstate) url-helpers (:update-appstate handlers)))
   :dashboard   (fnk [course handlers [:components dashboard course-form] url-helpers]
                     (dashboard {:main (course-form course url-helpers (:update-appstate handlers) )}))})
