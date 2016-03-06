(ns offcourse.views.components.course-form
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defc course-form [{:keys [curator course-id] :as course}]
  [:.container--card
   [:.card
    [:.card--title
     [:input.title {:placeholder "Enter Unique Title Here"}]]
    [:.card--checkpoints
     [:ul.todo-list
      [:li.todo-list--item {:data-selected ""}
       [:input {:placeholder "Add Task"}]]]]
     [:.card--tags (labels [{:label-name :add-task}] {:collection-url #(identity %)})]]])
