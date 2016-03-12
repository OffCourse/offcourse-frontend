(ns offcourse.views.components.card
  (:require [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.todo :refer [todo-list]]
            [rum.core :as rum]))

(rum/defc card [{:keys [goal tags description course-slug checkpoints curator] :as course}
                {:keys [checkpoint-url] :as helpers}]
  [:.container--card
   [:.card
    [:.card--title
     [:a.title {:href (checkpoint-url curator course-slug "index")} goal]]
    [:.card--checkpoints (todo-list checkpoints
                                    {:checkpoint-url (partial checkpoint-url curator course-slug)})]
    [:.card--tags (labels (:tags (meta course)) helpers)]
    #_[:.card--description [:p description]]
    #_[:.card--meta (meta-box course)]]])

(rum/defc cards [items helpers]
  [:.cards (map #(rum/with-key (card % helpers) (:course-id %)) items)])
