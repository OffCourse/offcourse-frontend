(ns offcourse.views.checkpoint
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.card :refer [card]]
            [offcourse.views.components.dashboard :refer [dashboard]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [content] :as resource}]
  [:.viewer
   (if content
     [:.content {:dangerouslySetInnerHTML {:__html (md->html content)}}]
     [:.loading "Waiting"])])

(rum/defc view [{:keys [view-name resource labels course]} helpers]
  [:.layout--app.app
   [:.layout--dashboard (dashboard (card course helpers) helpers)]
   [:.layout--main (viewer resource)]])
