(ns offcourse.views.components.logo
  (:require [rum.core :as rum]))

(rum/defc logo [{:keys [site-title] :as data}
                responder]
  [:.logo
   [:a {:href "/"} site-title]])
