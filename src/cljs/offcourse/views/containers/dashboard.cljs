(ns offcourse.views.containers.dashboard
  (:require [rum.core :as rum]))

(rum/defc dashboard [{:keys [logo main nav colorful]}]
  [:.dashboard {:data-colorful colorful}
   [:.dashboard--main main]])
