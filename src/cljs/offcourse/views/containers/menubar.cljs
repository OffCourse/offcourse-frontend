(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]
            [clojure.string :as str]))

(rum/defc action-panel [actions]
  [:ul
   (for [[key action] actions]
     [:li.textbar {:key key}
      [:a {:href "#"
           :on-click #(action)} "+"]])])

(rum/defc sign-in-button [user-name sign-in]
  [:.sign-in
   (if user-name
     [:div.textbar (str/capitalize (name user-name))]
     [:button.textbar {:on-click #(sign-in {:name :yeehaa})} "Sign In"])])

(rum/defc menubar [{:keys [logo actions user-name]}]
  [:.menubar
   [:.menubar--logo logo]
   [:menubar-actions
    [:nav
     (sign-in-button user-name (:sign-in actions))]]])
