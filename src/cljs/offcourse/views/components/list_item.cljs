(ns offcourse.views.components.list-item
  (:require [rum.core :as rum]))

(defn delete-checkpoint [update-appstate checkpoint-slug]
  (update-appstate {:type :update-deps
                    :actions {:type :delete
                              :checkpoints [{:checkpoint-slug checkpoint-slug}]}}))

(rum/defc list-item [{:keys [task checkpoint-slug]}
                     {:keys [update-appstate]}
                     dirty?]
  [:li.list--item
   [:p
    [:span {:key :title} task]
    (when dirty? [:span {:key :remove
                         :data-remove true
                         :on-click #(delete-checkpoint update-appstate checkpoint-slug)}
                  "Delete"])]])
