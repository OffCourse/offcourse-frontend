(ns offcourse.system.views
  (:require [offcourse.views.components.card :refer [card cards]]
            [offcourse.views.components.collection-panel :refer [collection-panels]]
            [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.components.navigation-panel :refer [navigation-panel]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [offcourse.views.containers.app :refer [app]]
            [plumbing.core :refer-macros [fnk]]
            [medley.core :as medley]))

(def base-graph
  {:container (fnk [] app)})

(def collection-graph
  {:labels    (fnk [viewmodel] (:labels viewmodel))
   :courses   (fnk [viewmodel] (:courses viewmodel))
   :actions   (fnk [handlers] [])
   :main      (fnk [courses route-helpers] (cards courses route-helpers))
   :dashboard (fnk [route-helpers actions labels]
                   (dashboard {:logo     (logo route-helpers)
                               :main     (collection-panels labels route-helpers)
                               :nav      (navigation-panel actions)
                               :colorful true}))})


(def checkpoint-graph
  {:course    (fnk [viewmodel] (:course viewmodel))
   :resource  (fnk [viewmodel] (:resource viewmodel))
   :course-id (fnk [course] (:course-id course))
   :main      (fnk [resource] (viewer resource))
   :actions   (fnk [handlers course-id]
                   (medley/map-kv #(vector %1 (partial %2 course-id)) handlers))
   :dashboard (fnk [route-helpers course actions]
                   (dashboard {:logo     (logo route-helpers)
                               :main     (card course route-helpers)
                               :nav      (navigation-panel actions)
                               :colorful false}))})

(def views
  {:collection-view (merge base-graph collection-graph)
   :checkpoint-view (merge base-graph checkpoint-graph)})