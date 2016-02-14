(ns offcourse.views.course
  (:require [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.dashboard :refer [dashboard]]
            [rum.core :as rum]))

(rum/defc view [{:keys [view-name labels course] :as vm}]
  [:.layout--app.app
   [:.layout--dashboard (dashboard (card course))]
   [:.layout--main nil]])

