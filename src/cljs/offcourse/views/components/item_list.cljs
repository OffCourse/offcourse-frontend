(ns offcourse.views.components.item-list
  (:require [rum.core :as rum]))

(rum/defc todo-list-item [{:keys [task completed? checkpoint-slug order] :as checkpoint}
                          {:keys [checkpoint-url]}
                          {:keys [toggle-checkpoint]}
                          trackable?]
  (let [{:keys [selected]} (meta checkpoint)
        url (checkpoint-url checkpoint-slug)]
    [:li.list--item {:data-selected selected
                     :data-item-type :todo}
     (when trackable? [:button.button {:key :checkbox
                       :data-button-type :checkbox
                       :on-click #(toggle-checkpoint checkpoint %1)
                       :disabled (not trackable?)
                       :data-selected (boolean completed?)} nil])
     [:a {:key :title
          :href url} [:span task]]]))

(rum/defc list-item [{:keys [task] :as checkpoint}
                     {:keys [delete-checkpoint]}]
  [:li.list--item
   [:span {:key :title} task]
   [:button.button {:key :add-button
                    :data-button-type (name :icon)
                    :on-click #(delete-checkpoint checkpoint)} "X"]])

(rum/defc item-list [list-type checkpoints url-helpers handlers trackable?]
  [:ul.list {:data-list-type (name list-type)}
   (case list-type
     :todo (map #(rum/with-key (todo-list-item % url-helpers handlers trackable?) (:checkpoint-id %)) checkpoints)
     :edit (map #(rum/with-key (list-item % handlers) (:checkpoint-id %)) checkpoints))])
