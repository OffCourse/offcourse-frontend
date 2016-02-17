(ns offcourse.views.collection
  (:require [offcourse.models.view :as view]
            [offcourse.views.components.card :refer [cards]]
            [offcourse.views.components.collection-panel :refer [collection-panels]]
            [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.containers.dashboard :refer [dashboard]]))

(defn view [{:keys [view-name labels courses]} helpers]
  (let [panels    (collection-panels labels (select-keys helpers [:collection-url]))
        main     (cards courses
                         (select-keys helpers [:collection-url :checkpoint-url]))
        dashboard (dashboard {:logo (logo (select-keys helpers [:home-url]))
                              :main panels
                              :nav  nil})]
    (view/new app {:dashboard dashboard
                   :main main})))
