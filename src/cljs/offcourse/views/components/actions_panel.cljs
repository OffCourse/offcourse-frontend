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

(defn handler-button [action-name respond]
  [:li.button {:data-button-type "textbar"
               :key [action-name]
               :on-click #(respond [action-name])}
   (button-title action-name)])

(rum/defc actions-panel [{:keys [user-name]        :as data}
                         respond
                         {:keys [profile-url]      :as url-helpers}]
  [:ul.actions-panel
   (when user-name (url-button user-name (profile-url user-name)))
   (if user-name
     (handler-button :sign-out respond)
     (handler-button :sign-in respond))])
