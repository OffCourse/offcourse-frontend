(ns offcourse.views.components.dashboard
  (:require [offcourse.views.components.logo :refer [logo]]
            [rum.core :as rum]))

(rum/defc dashboard [main helpers]
  [:.dashboard
   [:.dashboard--logo (logo helpers)]
   [:.dashboard--main main]])
