(ns offcourse.views.components.course-form
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defcs course-form < (rum/local {}) [state course update-appstate]
  (let [local (:rum/local state)]
    (swap! local #(merge % course))
    [:.container--card
     [:.card
      [:.card--title {:key :title}
       [:input.title {:placeholder "Enter Unique Title Here"
                      :value (:goal @local)
                      :on-change (fn [event]
                                   (swap! local #(assoc % :goal (-> event .-target .-value))))
                      :on-blur #(update-appstate {:view-data {:course @local}})}]]
      [:.card--checkpoints {:key :checkpoints}
       [:ul.todo-list
        [:li.todo-list--item {:data-selected ""}
         [:input {:placeholder "Add Task"}]]]]
      [:.card--tags {:key :tags} (labels [{:label-name :add-task}] {:collection-url #(identity %)})]]]))
