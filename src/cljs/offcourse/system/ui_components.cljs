(ns offcourse.system.ui-components
  (:require [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.components.card :refer [cards]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.components.viewer :refer [viewer-meta]]
            [offcourse.views.components.course-form :refer [course-form]]
            [offcourse.views.components.user-form :refer [user-form]]
            [offcourse.views.components.strips :refer [strips]]
            [offcourse.views.components.sheets :refer [sheets sheet]]
            [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.actions-panel :refer [actions-panel]]
            [offcourse.views.containers.menubar :refer [menubar]]
            [offcourse.views.containers.checkpoint-container :refer [checkpoint-container]]))

(def ui-components
  {:logo logo
   :app app
   :card card
   :cards cards
   :viewer viewer
   :viewer-meta viewer-meta
   :actions-panel actions-panel
   :strips strips
   :sheets sheets
   :sheet sheet
   :course-form course-form
   :user-form user-form
   :dashboard dashboard
   :menubar menubar
   :checkpoint-container checkpoint-container})
