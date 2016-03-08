(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [bidi.bidi :refer [path-for]]))

(rum/defc resource-list-item [{:keys [title tags url] :as resource} url-helpers]
  [:.container
   [:li.resource-list--item
    [:.info
     [:h1.title title]
     [:p.url url]]
    [:.tags (labels (map (fn [tag] {:label-name tag}) tags)
                    url-helpers)]]])

(rum/defc resource-list [resources url-helpers]
  [:ul.resource-list
   (map #(rum/with-key (resource-list-item % url-helpers) (:url %))
        resources)])
