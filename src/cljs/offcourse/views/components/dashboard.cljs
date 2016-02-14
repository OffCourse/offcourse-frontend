(ns offcourse.views.components.dashboard
  (:require [offcourse.views.components.logo :refer [logo]]
            [rum.core :as rum]))


(rum/defc dashboard [main]
  [:.dashboard
   [:.dashboard--logo (logo)]
   [:.dashboard--main main]])
