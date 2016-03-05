(ns offcourse.views.components.logo
  (:require [rum.core :as rum]))

(rum/defc logo [title url]
  [:.logo
   [:a.logo.textbar {:href url} title]])
