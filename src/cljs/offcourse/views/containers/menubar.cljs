(ns offcourse.views.containers.menubar
  (:require [rum.core :as rum]))

(rum/defc menubar [{:keys [logo colorful]}]
  [:.menubar {:data-colorful colorful}
   [:.menubar--logo logo]])
