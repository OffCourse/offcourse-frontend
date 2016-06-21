(ns offcourse.views.components.user-form
  (:require [rum.core :as rum]
            [cuerdas.core :as str]))

(defn button-title [string]
  (-> string
      name
      str/humanize
      str/titleize))

(rum/defc user-form  [{:keys [user-name] :as profile}
                      {:keys [update-user-name save-profile] :as handlers}]
  (let [dirty?   (not (:saved? (meta profile)))
        enabled? (and (:valid? (meta profile)))]
    [:.container
     [:.card
      [:.card--section {:key :user-name}
       [:input.title {:placeholder "Your Name"
                      :value (when user-name (button-title (name user-name)))
                      :on-change update-user-name}]]
      [:.card--section {:key :actions}
       [:.actions
        (when dirty?
          [:button.button {:key :save-course
                           :data-button-type :textbar
                           :on-click save-profile
                           :disabled (not enabled?)} "Save"])]]]]))
