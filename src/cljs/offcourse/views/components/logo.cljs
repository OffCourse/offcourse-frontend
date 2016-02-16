(ns offcourse.views.components.logo
  (:require [rum.core :as rum]))

(rum/defc logo [{:keys [home-url]}]
  [:.logo
   [:a.logo.textbar {:href home-url} "Offcourse_"]])
