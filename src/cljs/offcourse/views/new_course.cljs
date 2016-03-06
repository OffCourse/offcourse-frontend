(ns offcourse.views.new-course
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:course-data   (fnk [view-data] (:course view-data))
   :course        (fnk [course-data] course-data)
   :resources     (fnk [appstate] (println (keys (:resources appstate))))
   :dashboard     (fnk [course [:components dashboard course-form]]
                       (dashboard {:main (course-form course)}))})
