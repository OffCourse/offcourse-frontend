(ns offcourse.views.components.item-list
  (:require [rum.core :as rum]))


(rum/defc todo-list-item [{:keys [task completed? checkpoint-slug order] :as checkpoint}]
  (let [{:keys [selected checkpoint-url]} (meta checkpoint)
        trackable? false]
    [:li.list--item {:data-selected selected
                     :data-item-type :todo}
     (when trackable? [:button.button {:key :checkbox
                       :data-button-type :checkbox
                       :on-click nil #_(toggle-checkpoint checkpoint %1)
                       :disabled (not trackable?)
                       :data-selected (boolean completed?)} nil])
     [:a {:key :title
          :href checkpoint-url} [:span task]]]))

(rum/defc list-item [{:keys [task] :as checkpoint}]
  [:li.list--item
   [:span {:key :title} task]
   [:button.button {:key :add-button
                    :data-button-type (name :icon)
                    :on-click nil #_(remove-checkpoint checkpoint)} "X"]])

(rum/defc item-list [list-type checkpoints]
  [:ul.list {:data-list-type (name list-type)}
   (case list-type
     :todo (map #(rum/with-key (todo-list-item %) (:checkpoint-id %)) checkpoints)
     :edit (map #(rum/with-key (list-item %) (:checkpoint-id %)) checkpoints))])
