(ns offcourse.views.components.checkpoint-form
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]
            [cuerdas.core :as str]))

(rum/defc checkpoint-form [{:keys [tags url task] :as checkpoint}
                           tag
                           url-helpers
                           {:keys [update-url
                                   update-task
                                   save-tag
                                   update-tag
                                   save-checkpoint]}]
  [:.container
   [:li.resource-list--item
     [:h1.add-btn {:key :add-button
           :on-click save-checkpoint} "+"]
    [:.info
     [:input.title {:key :title
                    :placeholder "Task"
                    :value task
                    :on-change update-task}]
     [:input.url {:key :url
                  :placeholder "URL"
                  :value url
                  :on-change update-url}]]
    [:form.tags
     {:on-submit save-tag}
     (labels (map (fn [tag] {:label-name tag}) tags) url-helpers)
     [:input.tag {:placeholder "Add Tag"
                  :value tag
                  :on-change update-tag
                  :name "tag"}]
     [:input.submit {:type "submit"
                     :value "+"}]]]])

