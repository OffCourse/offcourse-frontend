(ns offcourse.views.components.checkpoint-form
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [labels]]))

(rum/defc checkpoint-form [{:keys [tags url task] :as checkpoint}
                              url-helpers
                              {:keys [update-appstate save-checkpoint]}]
  [:.container
   [:li.resource-list--item
    [:.info
     [:h1 {:key :add-button
           :on-click save-checkpoint} "+"]
     [:input.title {:key :title
                    :placeholder "Task"
                    :value task
                    :on-change #(update-appstate  {:type :update-task
                                                   :task (-> % .-target .-value)})}]
     [:input.url {:key :url
                  :placeholder "URL"
                  :value url
                  :on-change #(update-appstate  {:type :update-url
                                                 :url (-> % .-target .-value)})}]]
    [:form.tags
     {:on-submit (fn [event]
                   (.preventDefault event)
                   (println (-> event .-target .-tag .-value)))}
     (labels (map (fn [tag] {:label-name tag}) tags) url-helpers)
     [:input.tag {:placeholder "Add Tag"
                  :name "tag"}]
     [:input.submit {:type "submit"
                     :value "+"}]]]])

