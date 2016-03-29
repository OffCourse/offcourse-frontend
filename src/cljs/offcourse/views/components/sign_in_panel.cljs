(ns offcourse.views.components.sign-in-panel
  (:require [rum.core :as rum]
            [offcourse.fake-data.index :refer [users]]
            [cuerdas.core :as str]))

(rum/defc sign-in-panel [user-name sign-in profile-url-helper]
  [:.sign-in
   (if-not user-name
     [:button.button {:data-button-type :textbar
                      :on-click #(sign-in {:name (keyword (rand-nth users))})} "Sign In"]
     [:button.button {:data-button-type :textbar
                      :href (profile-url-helper user-name)} (-> user-name
                                                            name
                                                            str/titleize)])])
