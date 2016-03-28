(ns offcourse.views.containers.app
  (:require[rum.core :as rum]))

(rum/defc app [{:keys [main menubar dashboard]}]
  [:.layout
   [:.layout--section menubar]
   [:.layout--section
    [:.main
     (when dashboard [:.main--section dashboard])
     [:.main--section main]]]])
