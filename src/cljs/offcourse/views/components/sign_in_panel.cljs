(ns offcourse.views.components.sign-in-panel
  (:require [rum.core :as rum]
            [offcourse.fake-data.index :refer [users]]))

(rum/defc sign-in-panel [user-name sign-in profile-url-helper]
  [:.sign-in
   (if-not user-name
     [:button.textbar {:on-click #(sign-in {:name (keyword (rand-nth users))})} "Sign In"]
     [:a.textbar {:href (profile-url-helper user-name)} (name user-name)])])
