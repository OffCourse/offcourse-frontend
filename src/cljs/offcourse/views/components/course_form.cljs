(ns offcourse.views.components.course-form
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.todo :refer [item-list]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defc course-form  [course
                        {:keys [name]}
                        {:keys [checkpoint-url] :as helpers}
                        {:keys [update-appstate
                                save-course] :as handlers}]
  (let [dirty? (not (:saved? (meta course)))
        enabled? (and (:valid? (meta course)) name)]
   [:.container--card
     [:.card
      [:.card--title {:key :title}
       [:input.title {:placeholder "Goal"
                      :value (:goal course)
                      :on-change #(update-appstate  {:type :update-goal
                                                   :goal (-> % .-target .-value)})}]]
      [:.card--checkpoints {:key :checkpoints}
       (item-list :edit (:checkpoints course)
                  helpers
                  handlers
                  dirty?)]
      [:.card--tags {:key :tags} (labels (:tags (meta course)) helpers)]
      [:.card--actions {:key :actions}
       [:.actions
          (when dirty? [:button.textbar {:key :save-course
                             :on-click save-course
                             :disabled (not enabled?)} "Save Course"])]]]]))
