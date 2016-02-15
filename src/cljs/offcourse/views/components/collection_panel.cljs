(ns offcourse.views.components.collection-panel
  (:require [rum.core :as rum]
            [offcourse.views.components.label :refer [label]]))

(rum/defc collection-panel [[category-name collection]]
  (let [title (name category-name)]
    [:.collection-panel.l
     [:.collection-panel--title {:key :title}
      [:h1.title (name category-name)]]
     [:.collection-panel--labels.labels {:key :labels}
      (map #(rum/with-key (label %) (:label-name %)) collection)]]))

(rum/defc collection-panels [labels]
  [:.collection-panels
   (map #(rum/with-key (collection-panel %) %) labels)])
