(ns offcourse.views.components.label
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc label [{:keys [label-name] :as label} routes collection-type]
  (let [url (path-for routes :collection-view
                      :collection-type collection-type
                      :collection-name label-name)
        {:keys [selected?]} (meta label)
        label-name label-name
        title (name label-name)]
    [:span.label {:data-selected selected?}
     [:a {:href url} (str title " ")]]))

(rum/defc labels [labels routes collection-type]
  [:.labels (map #(rum/with-key (label % routes collection-type) (:label-name %)) labels)])
