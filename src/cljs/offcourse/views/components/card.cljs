(ns offcourse.views.components.card
  (:require [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.item-list :refer [item-list]]
            [rum.core :as rum]))

(rum/defc card [{:keys [goal tags description course-slug checkpoints curator] :as course}
                {:keys [checkpoint-url] :as helpers}]
  [:.container
   [:.card
    [:.card--section
     [:a.title {:href (checkpoint-url curator course-slug "index")} goal]]
    [:.card--section (item-list :todo checkpoints
                                    {:checkpoint-url (partial checkpoint-url curator course-slug)})]
    [:.card--section (labels (:tags (meta course)) helpers)]]])

(rum/defc cards [items helpers]
  [:.cards (map #(rum/with-key (card % helpers) (:course-id %)) items)])
