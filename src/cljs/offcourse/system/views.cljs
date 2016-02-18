(ns offcourse.system.views
  (:require [offcourse.views.components.card :refer [card cards]]
            [offcourse.views.components.collection-panel :refer [collection-panels]]
            [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.components.navigation-panel :refer [navigation-panel]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [offcourse.views.containers.app :refer [app]]
            [plumbing.core :refer-macros [fnk]]))

(def base-graph
  {:container (fnk [] app)
   :logo      (fnk [route-helpers] (logo route-helpers))
   :dashboard (fnk [logo dashboard-main nav colorful]
                   (dashboard {:logo     logo
                               :main     dashboard-main
                               :nav      nav
                               :colorful colorful}))})

(def collection-graph
  {:actions        (fnk [handlers] [])
   :dashboard-main (fnk [route-helpers labels]
                        (collection-panels labels route-helpers))
   :main           (fnk [courses route-helpers] (cards courses route-helpers))
   :nav            (fnk [actions] (navigation-panel actions))
   :colorful       (fnk [] true)})


(def checkpoint-graph
  {:dashboard-main (fnk [course route-helpers] (card course route-helpers))
   :main           (fnk [resource] (viewer resource))
   :nav            (fnk [handlers] (navigation-panel handlers))
   :colorful       (fnk [] false)})

(def views
  {:collection-view (merge base-graph collection-graph)
   :checkpoint-view (merge base-graph checkpoint-graph)})
