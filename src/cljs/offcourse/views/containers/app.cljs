(ns offcourse.views.containers.app
  (:require[rum.core :as rum]))

(rum/defc app [{:keys [main dashboard]}]
  [:.layout--app.app
   [:.layout--dashboard dashboard]
   [:.layout--main main]])
