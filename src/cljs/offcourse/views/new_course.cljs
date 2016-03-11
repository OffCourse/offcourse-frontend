(ns offcourse.views.new-course
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:course-data (fnk [view-data] (:course view-data))
   :course      (fnk [course-data] course-data)
   :main        (fnk [appstate handlers [:components resource-list] url-helpers]
                     (resource-list (:resources appstate) url-helpers (:update-appstate handlers)))
   :dashboard   (fnk [course handlers [:components dashboard course-form]]
                     (dashboard {:main (course-form course (:update-appstate handlers))}))})
