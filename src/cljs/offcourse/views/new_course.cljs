(ns offcourse.views.new-course
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn augment-course [{:keys [checkpoints] :as course}]
  (let [tags (-> (qa/get course :tags {})
                 (lb/collection->labels 0))]
    (some-> course
            (with-meta {:tags tags}))))

(def graph
  {:course-data (fnk [view-data] (:course view-data))
   :course      (fnk [appstate course-data]
                     (if-let [course (-> course-data
                                         augment-course)]
                       course
                       course-data))
   :user        (fnk [appstate] (:user appstate))
   :main        (fnk [appstate handlers [:components resource-list] url-helpers]
                     (resource-list (:resources appstate)
                                    url-helpers
                                    handlers))
   :view-actions (fnk [] {})
   :dashboard   (fnk [course user handlers [:components dashboard course-form] url-helpers]
                     (dashboard {:main (course-form course
                                                    user
                                                    url-helpers
                                                    handlers)}))})
