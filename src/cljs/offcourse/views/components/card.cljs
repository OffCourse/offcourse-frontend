(ns offcourse.views.components.card
  (:require [offcourse.models.course :as co]
            [offcourse.views.components.todo :refer [todo-list]]
            [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.meta-box :refer [meta-box]]
            [rum.core :as rum]
            [cljs.pprint :as pp]))

(rum/defc card [{:keys [goal description hashtag checkpoints curator] :as course}]
  [:.container--card
   [:.card
    [:.card--map]
    [:.card--title [:h1.title goal]]
    [:.card--meta (meta-box course)]
    [:.card--description [:p description]]
    [:.card--tags (labels (co/get-tags course))]
    [:.card--checkpoints (todo-list checkpoints)]]])

(rum/defc cards [items]
  [:.cards
   (map #(rum/with-key (card %) (:course-id %)) items)])
