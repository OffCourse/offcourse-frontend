(ns offcourse.view-components.app
  (:require [rum.core :as rum]))

(rum/defc app [viewmodel]
  [:section.app.layout-app
   [:div.layout-dashboard
    [:section.dashboard
     [:h1 "Offcourse"]]]
   [:div.layout-main]])
