(ns offcourse.views.course
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]
            [offcourse.protocols.decoratable :as dc]))

(def graph
  {:course-data   (fnk [appstate] (-> appstate :viewmodel :course))
   :course        (fnk [appstate course-data user-name]
                       (if-let [course (-> appstate
                                           (qa/get :course course-data)
                                           (dc/decorate user-name nil))]
                         course
                         course-data))
   :actions       (fnk [user-name [:url-helpers home-url new-course-url]]
                       {:add-course (when user-name (new-course-url user-name))})
   :checkpoints   (fnk [appstate course]
                       (map #(dc/decorate % appstate) (:checkpoints course)))
   :main          (fnk [course checkpoints [:components sheets] [:url-helpers collection-url checkpoint-url] [:handlers toggle-checkpoint]]
                       (let [url-helpers {:checkpoint-url (partial checkpoint-url (:curator course) (:course-slug course))
                                          :collection-url collection-url}
                             handlers {:toggle-checkpoint (partial toggle-checkpoint (:course-id course))}]
                         (sheets checkpoints url-helpers handlers (:trackable? (meta course)))))
   :dashboard     (fnk [url-helpers course handlers [:components card dashboard]]
                       (dashboard {:main (card course url-helpers handlers)}))})
