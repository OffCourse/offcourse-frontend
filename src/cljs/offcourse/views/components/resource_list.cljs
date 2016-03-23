(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.checkpoint-form :refer [checkpoint-form]]))

(rum/defc resource-list-item [{:keys [title checkpoint-count tags url tasks] :as resource}
                              url-helpers
                              {:keys [update-appstate]}]
  [:.container
   [:li.resource-list--item
    [:.info
     [:h1 {:on-click #(update-appstate {:type :add-checkpoint
                                        :checkpoint {:url  url
                                                     :task (first tasks)
                                                     :tags tags}})} "+"]
     [:h1.title (first tasks)]
     [:p.resource_title title]
     [:p.url url]]
    [:.tags (labels (map (fn [tag] {:label-name tag}) tags)
                    url-helpers)]]])


(rum/defc resource-list [resources checkpoint url-helpers handlers]
  [:ul.resource-list
   (checkpoint-form checkpoint url-helpers handlers)
   (map #(rum/with-key (resource-list-item % url-helpers handlers) (:url %))
        resources)])
