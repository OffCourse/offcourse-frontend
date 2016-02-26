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
    [:.card--title
     [:a.title {:href (checkpoint-url curator hashtag 1)} goal]]
    [:.card--checkpoints (todo-list checkpoints
                                    {:checkpoint-url (partial checkpoint-url curator hashtag)})]
    [:.card--tags (labels (:tags (meta course)) helpers)]
    #_[:.card--description [:p description]]
    #_[:.card--meta (meta-box course)]]])

(rum/defc cards [items helpers]
  [:.cards (map #(rum/with-key (card % helpers) (:course-id %)) items)])