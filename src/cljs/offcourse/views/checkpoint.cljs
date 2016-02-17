(ns offcourse.views.checkpoint
  (:require [offcourse.models.view :as view]
            [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.components.navigation-panel :refer [navigation-panel]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.containers.dashboard :refer [dashboard]]))

(defn view [{:keys [view-name resource labels course]} helpers]
  (let [card      (card course helpers)
        logo      (logo (select-keys helpers [:home-url]))
        main      (viewer resource)
        nav       (navigation-panel (select-keys helpers [:add-checkpoint
                                                          :edit-checkpoint]))
        dashboard (dashboard {:logo logo
                              :main card
                              :nav nav
                              :colorful false})]
    (view/new app {:dashboard dashboard
                   :main main})))
