(ns offcourse.views.containers.dashboard
  (:require [rum.core :as rum]))

(rum/defc dashboard [{:keys [logo main nav]}]
  [:.dashboard
   [:.dashboard--logo logo]
   [:.dashboard--main main]
   [:.dashboard--nav  nav]])
