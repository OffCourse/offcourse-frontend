(ns offcourse.views.new-course
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [plumbing.core :refer-macros [fnk]]
            [offcourse.protocols.decoratable :as dc]))

(def graph
  {:course-data (fnk [view-data] (:course view-data))
   :course      (fnk [appstate course-data]
                     (if-let [course (-> course-data
                                         dc/decorate)]
                       course
                       course-data))
   :checkpoint      (fnk [view-data]
                         (let [checkpoint (:checkpoint view-data)
                               valid? (va/valid? checkpoint)]
                           (with-meta checkpoint {:valid? valid?})))
   :tag      (fnk [view-data]
                  (:tag view-data))
   :user        (fnk [appstate] (:user appstate))
   :main        (fnk [appstate checkpoint tag handlers [:components strips] url-helpers]
                     (strips (:resources appstate)
                                    checkpoint
                                    tag
                                    url-helpers
                                    handlers))
   :actions   (fnk [user-name [:url-helpers home-url new-course-url]]
                   {:add-course (when user-name (new-course-url user-name))})
   :dashboard   (fnk [course user handlers [:components dashboard course-form] url-helpers]
                     (dashboard {:main (course-form course
                                                    user
                                                    url-helpers
                                                    handlers)}))})
