(ns offcourse.system.ui-components
  (:require [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.components.card :refer [cards]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.components.course-form :refer [course-form]]
            [offcourse.views.components.resource-list :refer [resource-list]]
            [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.sign-in-panel :refer [sign-in-panel]]
            [offcourse.views.components.actions-panel :refer [actions-panel]]
            [offcourse.views.containers.menubar :refer [menubar]]))


(def ui-components
  {:logo logo
   :app app
   :card card
   :cards cards
   :viewer viewer
   :sign-in-panel sign-in-panel
   :actions-panel actions-panel
   :resource-list resource-list
   :course-form course-form
   :dashboard dashboard
   :menubar menubar})
