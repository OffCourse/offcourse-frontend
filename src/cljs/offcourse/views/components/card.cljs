(ns offcourse.views.components.card
  (:require [offcourse.views.components.label :refer [labels]]
            [offcourse.views.components.item-list :refer [item-list]]
            [rum.core :as rum]))

(rum/defc card [{:keys [course-id goal tags description course-slug checkpoints curator] :as course}
                {:keys [course-url checkpoint-url] :as helpers}
                {:keys [toggle-checkpoint] :as handlers}]
  [:.container
   [:.card
    [:.card--section
     [:a.title {:href (course-url curator course-slug)} goal]]
    [:.card--section (item-list :todo checkpoints
                                {:checkpoint-url (partial checkpoint-url curator course-slug)}
                                {:toggle-checkpoint (partial toggle-checkpoint course-id)}
                                (:trackable? (meta course)))]
    [:.card--section (labels (:tags (meta course)) helpers)]]])

(rum/defc cards [items helpers handlers]
  [:.cards (map #(rum/with-key (card % helpers handlers) (:course-id %)) items)])
