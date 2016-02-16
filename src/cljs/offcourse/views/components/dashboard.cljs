(ns offcourse.views.components.dashboard
  (:require [offcourse.views.components.logo :refer [logo]]
            [rum.core :as rum]))

(rum/defc dashboard [main routes]
  [:.dashboard
   [:.dashboard--logo (logo routes)]
   [:.dashboard--main main]])
