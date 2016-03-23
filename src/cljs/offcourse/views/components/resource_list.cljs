(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [bidi.bidi :refer [path-for]]))

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

(rum/defc resource-form  [{:keys [task url checkpoint-slug] :as checkpoint}
                          {:keys [update-appstate save-checkpoint]}]
    [:.container
     [:li.resource-list--item
      [:.info {:key :info}
       [:h1 {:key :add-button
             :on-click save-checkpoint} "+"]
       [:input.title {:key :title
                      :placeholder "Task"
                      :value task
                      :on-blur #(update-appstate  {:type :update-task
                                                     :task (-> % .-target .-value)})}]
       [:p.resource_title {:key :resource-title} "loading.."]
       [:input.url {:key :url
                    :placeholder "URL"
                    :value url
                    :on-change #(update-appstate  {:type :update-url
                                                 :url (-> % .-target .-value)})}]]
      [:.tags {:key :tags
               :content-editable true
               :placeholder "tags"}]]])

(rum/defc resource-list [resources checkpoint url-helpers handlers]
  [:ul.resource-list
   (resource-form checkpoint handlers)
   (map #(rum/with-key (resource-list-item % url-helpers handlers) (:url %))
        resources)])
