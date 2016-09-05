(ns offcourse.views.components.course-form
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.item-list :refer [item-list]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defc course-form  [{:keys [goal checkpoints] :as course}
                        {:keys [user-name]}
                        {:keys [checkpoint-url] :as helpers}
                        {:keys [update-goal
                                save-course] :as handlers}]
  (let [dirty?   (not (:saved? (meta course)))
        enabled? (and (:valid? (meta course)) name)]
   [:.container
     [:.card
      [:.card--section {:key :title}
       [:input.title {:placeholder "Goal"
                      :value (or goal "")
                      :on-change update-goal}]]
      [:.card--section {:key :checkpoints}
       (item-list :edit checkpoints helpers handlers dirty?)]
      [:.card--section {:key :tags} (labels (:tags (meta course)) helpers)]
      [:.card--section {:key :actions}
       [:.actions
        (when dirty?
          [:button.button {:key :save-course
                           :data-button-type :textbar
                           :on-click save-course
                           :disabled (not enabled?)} "Save Course"])]]]]))
