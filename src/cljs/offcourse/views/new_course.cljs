(ns offcourse.views.new-course
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [plumbing.core :refer-macros [fnk]]))

(defn augment-course [{:keys [checkpoints] :as course}]
  (let [tags (-> (qa/get course :tags {})
                 (lb/collection->labels 0))
        valid? (va/valid? (co/complete course))
        saved? (:saved? (meta course))]
    (-> course (with-meta {:tags tags
                           :valid? valid?
                           :saved? saved?}))))

(def graph
  {:course-data (fnk [view-data] (:course view-data))
   :course      (fnk [appstate course-data]
                     (if-let [course (-> course-data
                                         augment-course)]
                       course
                       course-data))

   :checkpoint      (fnk [view-data]
                         (:checkpoint view-data))
   :tag      (fnk [view-data]
                  (:tag view-data))
   :user        (fnk [appstate] (:user appstate))
   :main        (fnk [appstate checkpoint tag handlers [:components resource-list] url-helpers]
                     (resource-list (:resources appstate)
                                    checkpoint
                                    tag
                                    url-helpers
                                    handlers))
   :actions     (fnk [] {})
   :dashboard   (fnk [course user handlers [:components dashboard course-form] url-helpers]
                     (dashboard {:main (course-form course
                                                    user
                                                    url-helpers
                                                    handlers)}))})
