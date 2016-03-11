(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [bidi.bidi :refer [path-for]]))

(rum/defc resource-list-item [{:keys [title checkpoint-count tags url tasks] :as resource}
                              url-helpers
                              update-appstate]
  [:.container
   [:li.resource-list--item
    [:.info
     [:h1 {:on-click #(update-appstate {:view-data
                                        {:checkpoint [{:url  url
                                                       :task (first tasks)}]}})} "+"]
     [:h1.title (first tasks)]
     [:p.resource_title title]
     [:p.checkpoint-count checkpoint-count]
     [:p.url url]]
    [:.tags (labels (map (fn [tag] {:label-name tag}) tags)
                    url-helpers)]]])

(rum/defc resource-list [resources url-helpers update-appstate]
  [:ul.resource-list
   (map #(rum/with-key (resource-list-item % url-helpers update-appstate) (:url %))
        resources)])
