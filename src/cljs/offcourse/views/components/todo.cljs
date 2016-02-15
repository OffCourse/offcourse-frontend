(ns offcourse.views.components.todo
  (:require [rum.core :as rum]))

(rum/defc todo-list-item [{:keys [task] :as checkpoint}]
  (let [{:keys [selected]} (meta checkpoint)]
    [:li.todo-list--item {:data-selected selected}
     [:p
      [:span.checkbox {:key :checkbox} nil]
      [:span {:key :title} task]]]))

(rum/defc todo-list [checkpoints]
  [:ul.todo-list
   (map #(rum/with-key (todo-list-item %) (:order %)) checkpoints)])
