(ns offcourse.views.components.logo
  (:require [rum.core :as rum]))

(rum/defc logo [title url]
  [:.logo
   [:a {:href url} title]])
