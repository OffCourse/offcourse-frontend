(ns offcourse.views.components.label
  (:require [rum.core :as rum]))

(rum/defc label [{:keys [label-name] :as label}]
  (let [label-name (or label-name label)
        title (name label-name)]
    [:span.label (str title " ")]))

(rum/defc labels [labels]
  [:.labels (map #(rum/with-key (label %) %) labels)])
