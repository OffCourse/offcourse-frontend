(ns offcourse.views.components.todo
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc todo-list-item [{:keys [task order] :as checkpoint} create-url]
  (let [{:keys [selected]} (meta checkpoint)
        url (create-url order)]
    [:li.todo-list--item {:data-selected selected}
     [:a {:href url} [:p
                      [:span.checkbox {:key :checkbox} nil]
                      [:span {:key :title} task]]]]))

(rum/defc todo-list [checkpoints create-url]
  [:ul.todo-list
   (map #(rum/with-key (todo-list-item % create-url) (:order %)) checkpoints)])
