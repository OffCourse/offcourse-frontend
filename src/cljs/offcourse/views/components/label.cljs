(ns offcourse.views.components.label
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc label [{:keys [label-name] :as label} {:keys [collection-url]}]
  (let [{:keys [selected?]} (meta label)
        label-name label-name
        title (name label-name)]
    [:span.label {:data-selected selected?}
     [:a {:href (collection-url label-name)} (str title " ")]]))

(rum/defc labels [labels {:keys [collection-url] :as helpers}]
  (let [helpers (assoc helpers :collection-url (partial collection-url :tags))]
    [:.labels (map #(rum/with-key (label % helpers)
                      (:label-name %)) labels)]))
