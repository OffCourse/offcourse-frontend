(ns offcourse.views.components.collection-panel
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]
            [offcourse.views.components.label :refer [label]]))

(rum/defc collection-panel [[category-name collection] {:keys [collection-url] :as helpers}]
  (let [helpers (assoc helpers :collection-url (partial collection-url category-name))]
    [:.collection-panel
     [:.collection-panel--title {:key :title}
      [:h1.title (name category-name)]]
     [:.collection-panel--labels.labels {:key :labels}
      (map #(rum/with-key (label % helpers) (:label-name %)) collection)]]))

(rum/defc collection-panels [labels helpers]
    [:.collection-panels (map #(rum/with-key (collection-panel % helpers) %) labels)])
