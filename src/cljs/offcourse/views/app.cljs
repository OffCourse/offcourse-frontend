(ns offcourse.views.app
  (:require [rum.core :as rum]
            [cljs.pprint :as pp]))

(rum/defc logo []
  [:button.logo.textbar.title "Offcourse_"])

(rum/defc label [{:keys [label-name] :as label}]
  (let [title (name label-name)]
    [:span.label (str title " ")]))

(rum/defc collection-panel [[category-name collection]]
  (let [title (name category-name)]
    [:.collection-panel
     [:.collection-panel.collection-panel__title {:key :title}
      [:h1.title (name category-name)]]
     [:.collection-panel.collection-panel__labels {:key :labels}
      (map #(rum/with-key (label %) (:label-name %)) collection)]]))

(rum/defc dashboard [label-collections]
  [:.dashboard
   [:.dashboard.dashboard__logo (logo)]
   [:.dashboard.dashboard__collections
    (map #(rum/with-key (collection-panel %) %) label-collections)]])

(rum/defc app [{:keys [labels]}]
  [:.app.layout--app
   [:.layout--dashboard (dashboard labels)]
   [:.layout--main]])
