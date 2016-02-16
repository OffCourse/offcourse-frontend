(ns offcourse.views.collection
  (:require [offcourse.views.components.dashboard :refer [dashboard]]
            [offcourse.views.components.card :refer [cards]]
            [offcourse.views.components.collection-panel :refer [collection-panels]]
            [bidi.bidi :refer [path-for]]
            [rum.core :as rum]))

(rum/defc view [{:keys [view-name labels courses]} helpers]
    [:.layout--app.app
     [:.layout--dashboard (dashboard (collection-panels labels helpers) helpers)]
     [:.layout--main (cards courses helpers)]])
