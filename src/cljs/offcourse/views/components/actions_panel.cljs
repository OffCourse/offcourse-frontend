(ns offcourse.views.components.actions-panel
  (:require [rum.core :as rum]
            [cuerdas.core :as str]))

(defn button-title [string]
  (-> string
      name
      str/humanize
      str/titleize))

(defn url-button [action-name url]
  [:li.button
   {:key [action-name]
    :data-button-type "textbar"}
   [:a {:href url} (button-title action-name)]])

(defn handler-button [action-name handler]
  [:li.button {:data-button-type "textbar"
               :key [action-name]
               :on-click #(handler)} (button-title action-name)])

(rum/defc actions-panel [actions user-name sign-in sign-out profile-url]
  [:ul.actions-panel
   (keep (fn [[action-name action-url]]
           (when action-url
             (url-button action-name action-url))) actions)
   (when user-name (url-button user-name (profile-url user-name)))
   (if user-name
     (handler-button :sign-out sign-out)
     (handler-button :sign-in sign-in))])
