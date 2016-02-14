(ns offcourse.views.components.meta-box
(:require [rum.core :as rum]))

(rum/defc meta-box [{:keys [hashtag curator]}]
  [:.meta-box
   [:p {:key :curator}  [:span.keyword "Curator: "] (name curator)]
   [:p {:key :learners} [:span.keyword "Hashtag: "] (name hashtag)]])
