(ns offcourse.views.components.item-list
  (:require [rum.core :as rum]))


(rum/defc todo-list-item [{:keys [task checkpoint-slug order] :as checkpoint}
                          {:keys [checkpoint-url]}]
  (let [{:keys [selected]} (meta checkpoint)
        url (checkpoint-url checkpoint-slug)]
    [:li.list--item {:data-selected selected
                     :data-item-type :todo}
     [:span.button {:key :checkbox
                    :data-button-type :checkbox} nil]
     [:a {:key :title
          :href url} [:span task]]]))

(rum/defc list-item [{:keys [task] :as checkpoint}
                     {:keys [delete-checkpoint]}
                     dirty?]
  [:li.list--item
   [:span {:key :title} task]
   (when dirty? [:span.button {:key :remove
                               :data-button-type :understated
                               :on-click #(delete-checkpoint checkpoint)}
                 "Delete"])])

(rum/defc item-list [list-type checkpoints url-helpers handlers dirty?]
  [:ul.list {:data-list-type (name list-type)}
   (case list-type
     :todo (map #(rum/with-key (todo-list-item % url-helpers) (:checkpoint-id %)) checkpoints)
     :edit (map #(rum/with-key (list-item % handlers dirty?) (:checkpoint-id %)) checkpoints))])
