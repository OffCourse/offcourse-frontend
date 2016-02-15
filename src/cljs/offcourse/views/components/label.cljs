(ns offcourse.views.components.label
  (:require [rum.core :as rum]))

(rum/defc label [{:keys [label-name] :as label}]
  (let [{:keys [selected?]} (meta label)
        label-name label-name
        title (name label-name)]
    [:span.label {:data-selected selected?} (str title " ")]))

(rum/defc labels [labels]
  [:.labels (map #(rum/with-key (label %) (:label-name %)) labels)])
