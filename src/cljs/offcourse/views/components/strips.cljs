(ns offcourse.views.components.strips
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels label-form]]))

(rum/defc strip-form [{:keys [tags url task] :as checkpoint}
                           tag
                           url-helpers
                           {:keys [update-url
                                   update-task
                                   save-tag
                                   update-tag
                                   save-checkpoint] :as handlers}]
  [:.container
   [:div.strip {:data-form true}
    [:.strip--section
     [:.btn {:key :add-button
             :on-click save-checkpoint} "+"]]
    [:.strip--section
     [:input.title {:key :title
                    :placeholder "Task"
                    :value task
                    :on-change update-task}]
     [:input.subtitle {:key :url
                       :placeholder "URL"
                       :value url
                       :on-change update-url}]]
   [:.strip--section
    (when-not (empty? tags)
      (labels (map (fn [tag] {:label-name tag}) tags) url-helpers))
      (label-form tag handlers)]]])

(rum/defc strip-base [{:keys [title checkpoint-count tags url tasks] :as resource}
                              url-helpers
                              {:keys [add-checkpoint]}]
  [:.container
   [:div.strip {:data-form true}
    [:.strip--section
    [:.btn {:on-click #(add-checkpoint {:url  url
                                        :task (first tasks)
                                        :tags tags})} "+"]]
    [:.strip--section
     [:h1.title (first tasks)]
     [:p.subtitle url]
     [:p.subtitle title]]
    [:.strip--section (labels (map (fn [tag] {:label-name tag}) tags)
                    url-helpers)]]])

(rum/defc strips [resources checkpoint tag url-helpers handlers]
  [:div.strips {:data-list-type "checkpoint"}
   (strip-form checkpoint tag url-helpers handlers)
   (map #(rum/with-key (strip-base % url-helpers handlers) (:url %))
        resources)])
