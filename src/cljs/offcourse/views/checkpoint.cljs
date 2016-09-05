(ns offcourse.views.checkpoint
  (:require [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [plumbing.core :refer-macros [fnk]]
            [shared.protocols.decoratable :as dc]
            [shared.protocols.queryable :as qa]))

(def graph
  {:checkpoint-data (fnk [viewmodel] (or (-> viewmodel :checkpoint) {:checkpoint-slug nil}))
   :course-data     (fnk [viewmodel] (-> viewmodel :course))
   :course          (fnk [appstate
                          course-data
                          checkpoint-data
                          routes
                          user-name]
                         (some-> appstate
                                 (qa/get course-data)
                                 (dc/decorate user-name checkpoint-data routes)))
   :checkpoint      (fnk [appstate
                          course
                          checkpoint-data]
                         (some-> course
                                 (qa/get checkpoint-data)))
   :resource        (fnk [appstate
                          checkpoint]
                         (when checkpoint
                           #_(qa/get appstate {:url (:url checkpoint)})))
   :actions         (fnk [base-actions]
                         (->> base-actions
                              (into #{})))
   :main            (fnk [checkpoint
                          resource]
                         (viewer {:resource resource} nil nil))
   :dashboard       (fnk [user-name
                          course
                          actions]
                         (when course
                           (dashboard {:main (card course)})))})
