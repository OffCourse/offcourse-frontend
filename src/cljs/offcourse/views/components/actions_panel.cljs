(ns offcourse.views.components.actions-panel
  (:require [rum.core :as rum]
            [cuerdas.core :as str]))

(rum/defc actions-panel [actions user-name sign-in sign-out profile-url]
  [:ul.actions-panel
   (keep (fn [[action-name action-url]]
           (when action-url
             [:li.button
              {:key [action-name]
               :data-button-type "textbar"}
              [:a {:href action-url} (-> action-name
                                         name
                                         str/humanize
                                         str/titleize)]])) actions)
   (when user-name
     [:li.button
      {:key :profile
       :data-button-type "textbar"}
      [:a {:href (profile-url user-name)} (-> user-name
                                              name
                                              str/titleize)]])
   (if user-name
     [:li.button {:data-button-type "textbar"
                  :on-click #(sign-out)} "Sign Out"]
     [:li.button {:data-button-type "textbar"
                  :on-click #(sign-in)} "Sign In"])])
