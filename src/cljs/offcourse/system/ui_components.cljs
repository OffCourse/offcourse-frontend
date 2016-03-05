(ns offcourse.system.ui-components
  (:require [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.components.card :refer [cards]]
            [offcourse.views.containers.dashboard :refer [dashboard]]
            [offcourse.views.components.viewer :refer [viewer]]
            [offcourse.views.components.card :refer [card]]
            [offcourse.views.containers.menubar :refer [menubar]]))

(def ui-components
  {:logo logo
   :app app
   :card card
   :cards cards
   :viewer viewer
   :dashboard dashboard
   :menubar menubar})
