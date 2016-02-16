(ns offcourse.views.components.card
  (:require [offcourse.models.course :as co]
            [offcourse.views.components.todo :refer [todo-list]]
            [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.meta-box :refer [meta-box]]
            [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(defn create-url [routes curator hashtag checkpoint-id]
  (path-for routes :checkpoint-view
            :curator curator
            :hashtag hashtag
            :checkpoint-id checkpoint-id))

(rum/defc card [{:keys [goal tags description hashtag checkpoints curator] :as course} routes]
  [:.container--card
   [:.card
    [:.card--map]
    [:.card--title [:a.title {:href (create-url routes curator hashtag 1)} goal]]
    [:.card--meta (meta-box course)]
    [:.card--description [:p description]]
    [:.card--tags (labels (:tags (meta course)) routes :tags)]
    [:.card--checkpoints (todo-list checkpoints
                                    (partial create-url routes curator hashtag))]]])

(rum/defc cards [items routes]
  [:.cards
   (map #(rum/with-key (card % routes) (:course-id %)) items)])
