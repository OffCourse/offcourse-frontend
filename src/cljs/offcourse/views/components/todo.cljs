(ns offcourse.views.components.todo
  (:require [rum.core :as rum]))

(rum/defc todo-list-item [{:keys [task checkpoint-slug order] :as checkpoint}
                          {:keys [checkpoint-url]}]
  (let [{:keys [selected]} (meta checkpoint)
        url (checkpoint-url checkpoint-slug)]
    [:li.list--item {:data-selected selected
                     :data-item-type :todo}
     [:a {:href url} [:p
                      [:span.checkbox {:key :checkbox} nil]
                      [:span {:key :title} task]]]]))

(rum/defc list-item [{:keys [task checkpoint-slug]}
                     {:keys [update-appstate]}]
  [:li.list--item
   [:p
    [:span {:key :title} task]
    [:span {:key :remove
            :data-remove true
            :on-click #(update-appstate
                        {:type :update-deps
                         :actions {:type :delete
                                   :checkpoints [{:checkpoint-slug checkpoint-slug}]}})}
     "Delete"]]])

(rum/defc item-list [list-type checkpoints url-helpers handlers]
  [:ul.item-list {:data-list-type list-type}
   (case list-type
     :todo (map #(rum/with-key (todo-list-item % url-helpers) (:checkpoint-id %)) checkpoints)
     :edit (map #(rum/with-key (list-item % handlers) (:checkpoint-id %)) checkpoints))])
