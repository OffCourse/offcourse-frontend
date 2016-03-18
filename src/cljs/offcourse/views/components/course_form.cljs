(ns offcourse.views.components.course-form
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.todo :refer [item-list]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defcs course-form < (rum/local {}) [state
                                         course
                                         {:keys [name]}
                                         {:keys [checkpoint-url] :as helpers}
                                         {:keys [update-appstate
                                                 save-course] :as handlers}]
  (let [local (:rum/local state)]
   [:.container--card
     [:.card
      [:.card--title {:key :title}
       [:input.title {:placeholder "Enter Unique Title Here"
                      :value (:goal @local)
                      :on-change (fn [event]
                                   (swap! local #(assoc % :goal (-> event .-target .-value))))
                      :on-blur #(update-appstate {:type :update-deps
                                                  :actions {:goal (:goal @local)}})}]]
      [:.card--checkpoints {:key :checkpoints}
       (item-list :edit (:checkpoints course)
                  helpers
                  handlers)]
      [:.card--tags {:key :tags} (labels (:tags (meta course)) helpers)]
      [:.card--actions {:key :actions}
       [:.actions
        (let [enabled? (and (:valid? (meta course))
                             (not (:saved? (meta course)))
                             name)]
          [:button.textbar {:key :save-course
                            :on-click save-course
                            :disabled (not enabled?)} "Save Course"])]]]]))
