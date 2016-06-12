(ns offcourse.views.checkpoint
  (:require [offcourse.protocols.decoratable :as dc]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:checkpoint-slug (fnk [appstate] (-> appstate :viewmodel :checkpoint :checkpoint-slug))
   :course-data     (fnk [appstate] (-> appstate :viewmodel :course))
   :course        (fnk [appstate course-data user-name]
                       (if-let [course (qa/get appstate :course course-data)]
                         course
                         nil))
   :checkpoint      (fnk [appstate course checkpoint-slug]
                         (when course (qa/get course :checkpoint {:checkpoint-slug checkpoint-slug})))
   :actions         (fnk [user-name [:url-helpers home-url new-course-url]]
                         {:add-course (when user-name (new-course-url user-name))})
   :main            (fnk [checkpoint [:components viewer]]
                         (viewer checkpoint))
   :dashboard       (fnk [url-helpers user-name course checkpoint-slug handlers [:components card dashboard]]
                         (when course
                           (let [course (dc/decorate course user-name checkpoint-slug)]
                             (dashboard {:main (card course url-helpers handlers)}))))})
