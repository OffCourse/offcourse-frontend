(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.checkpoint-form :refer [checkpoint-form]]))

(rum/defc resource-list-item [{:keys [title checkpoint-count tags url tasks] :as resource}
                              url-helpers
                              {:keys [add-checkpoint]}]
   [:li.list--item
    [:.btn--add {:on-click #(add-checkpoint {:url  url
                                              :task (first tasks)
                                              :tags tags})} "+"]
    [:.info
     [:h1.title (first tasks)]
     [:p.url url]
     [:p.resource_title title]]
    [:.tags (labels (map (fn [tag] {:label-name tag}) tags)
                    url-helpers)]])

(rum/defc resource-list [resources checkpoint tag url-helpers handlers]
  [:ul.list {:data-list-type "checkpoint"}
   (checkpoint-form checkpoint tag url-helpers handlers)
   (map #(rum/with-key (resource-list-item % url-helpers handlers) (:url %))
        resources)])
