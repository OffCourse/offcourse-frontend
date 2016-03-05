(ns offcourse.views.containers.dashboard
  (:require [rum.core :as rum]))

(rum/defc dashboard [{:keys [main]}]
  [:.dashboard
   [:.dashboard--main main]])
