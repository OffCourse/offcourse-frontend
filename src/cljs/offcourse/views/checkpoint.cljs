(ns offcourse.views.checkpoint
  (:require [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.dashboard :refer [dashboard]]
            [markdown.core :refer [md->html]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [content] :as resource}]
  [:.viewer
   (if content
     [:.content {:dangerouslySetInnerHTML {:__html (md->html content)}}]
     [:.loading "Waiting"])])

(rum/defc view [{:keys [view-name resource checkpoint-id labels course] :as vm}]
  [:.layout--app.app
   [:.layout--dashboard (dashboard (card course))]
   [:.layout--main (viewer resource)]])
