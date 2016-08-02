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
                         (when course (-> (qa/get course :checkpoint {:checkpoint-slug checkpoint-slug})
                                          (dc/decorate appstate))))
   :actions         (fnk [user-name [:url-helpers home-url new-course-url]]
                         {:add-course (when user-name (new-course-url user-name))})

   :main            (fnk [course checkpoint [:components viewer checkpoint-container sheet] [:url-helpers collection-url checkpoint-url] [:handlers toggle-checkpoint]]
                         (let [url-helpers {:checkpoint-url (partial checkpoint-url (:curator course) (:course-slug course))
                                            :collection-url collection-url }
                               handlers {:toggle-checkpoint (partial toggle-checkpoint (:course-id course))}]
                              (checkpoint-container {:sheet  (sheet checkpoint url-helpers handlers (:trackable? (meta course)))
                                                     :viewer (viewer checkpoint)})))

   :dashboard       (fnk [url-helpers user-name course checkpoint-slug handlers [:components card dashboard]]
                         (when course
                           (let [course (dc/decorate course user-name checkpoint-slug)]
                             (dashboard {:main (card course url-helpers handlers)}))))})
