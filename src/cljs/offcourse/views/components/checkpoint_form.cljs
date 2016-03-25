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
  [:li.list--item {:data-form true}
   [:.btn--add {:key :add-button
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
   [:div.tags
    (when-not (empty? tags) (labels (map (fn [tag] {:label-name tag}) tags) url-helpers))
    [:form.tag--input {:on-submit save-tag}
     [:input.tag {:placeholder "Tag"
                  :value tag
                  :on-change update-tag
                  :name "tag"}]
     [:input.submit {:type "submit"
                     :value "+"}]]]])

