(ns offcourse.views.components.todo
  (:require [rum.core :as rum]))

(rum/defc todo-list-item [{:keys [task]}]
  [:li.todo-list--item
   [:p
    [:span.checkbox {:key :checkbox} nil]
    [:span {:key :title} task]]])

(rum/defc todo-list [checkpoints]
  [:ul.todo-list
   (map #(rum/with-key (todo-list-item %) (:order %)) checkpoints)])
