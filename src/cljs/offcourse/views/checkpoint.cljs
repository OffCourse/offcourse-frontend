(ns offcourse.views.checkpoint
  (:require [offcourse.protocols.decoratable :as dc]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:checkpoint-slug (fnk [view-data]
                         (-> view-data :checkpoint :checkpoint-slug))
   :course-data   (fnk [view-data] (:course view-data))
   :course        (fnk [appstate course-data checkpoint-slug user-name]
                       (if-let [course (-> appstate
                                           (qa/get :course course-data)
                                           (dc/decorate user-name checkpoint-slug))]
                         course
                         course-data))
   :checkpoint (fnk [appstate course checkpoint-slug]
                    (-> course
                        (qa/get :checkpoint {:checkpoint-slug checkpoint-slug})
                        (dc/decorate appstate)))
   :actions   (fnk [user-name [:url-helpers home-url new-course-url]]
                   {:add-course (when user-name (new-course-url user-name))})
   :main          (fnk [checkpoint [:components viewer]]
                       (viewer checkpoint))
   :dashboard     (fnk [url-helpers course handlers [:components card dashboard]]
                       (dashboard {:main (card course url-helpers handlers)}))})
