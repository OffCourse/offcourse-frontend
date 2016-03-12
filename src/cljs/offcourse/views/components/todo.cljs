(ns offcourse.views.components.todo
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc todo-list-item [{:keys [task checkpoint-slug order] :as checkpoint} {:keys [checkpoint-url]}]
  (let [{:keys [selected]} (meta checkpoint)
        url (checkpoint-url checkpoint-slug)]
    [:li.todo-list--item {:data-selected selected}
     [:a {:href url} [:p
                      [:span.checkbox {:key :checkbox} nil]
                      [:span {:key :title} task]]]]))

(rum/defc todo-list [checkpoints create-url]
  [:ul.todo-list
   (map #(rum/with-key (todo-list-item % create-url) (:checkpoint-id %)) checkpoints)])
