(ns offcourse.views.base
  (:require [rum.core :as rum]
            [plumbing.core :refer-macros [fnk]]))

(rum/defc action-panel [user-name new-course-url sign-in]
   (if user-name
     [:ul
      [:li.textbar [:a {:href (new-course-url user-name)} "Add Course"]]]
     [:.sign-in
      [:button.textbar {:on-click #(sign-in {:name :yeehaa})} "Sign In"]]))

(def graph
  {:container (fnk [[:components app]] app)
   :view-data (fnk [appstate] (:view-data appstate))
   :view-name (fnk [appstate] (:view-type appstate))
   :menubar   (fnk [[:appstate user site-title]
                    [:url-helpers home-url new-course-url]
                    handlers
                    [:components logo menubar]]
                   (menubar {:logo    (logo site-title home-url)
                             :action-panel (action-panel (:name user)
                                                         new-course-url
                                                         (:sign-in handlers))}))})
