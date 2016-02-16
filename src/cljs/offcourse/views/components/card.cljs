(ns offcourse.views.components.card
  (:require [offcourse.models.course :as co]
            [offcourse.views.components.todo :refer [todo-list]]
            [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.meta-box :refer [meta-box]]
            [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc card [{:keys [goal tags description hashtag checkpoints curator] :as course}
                {:keys [checkpoint-url] :as helpers}]
  [:.container--card
   [:.card
    [:.card--map]
    [:.card--title [:a.title {:href (checkpoint-url curator hashtag 1)} goal]]
    [:.card--meta (meta-box course)]
    [:.card--description [:p description]]
    [:.card--tags (labels (:tags (meta course)) helpers)]
    [:.card--checkpoints (todo-list checkpoints
                                    {:checkpoint-url (partial checkpoint-url curator hashtag)})]]])

(rum/defc cards [items helpers]
  [:.cards (map #(rum/with-key (card % helpers) (:course-id %)) items)])
