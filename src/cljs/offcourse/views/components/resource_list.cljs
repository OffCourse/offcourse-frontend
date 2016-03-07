(ns offcourse.views.components.resource-list
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]))

(rum/defc resource-list-item [resource]
  [:li.resource-list--item (:title resource)])

(rum/defc resource-list [resources]
  [:ul.resource-list
   (map #(rum/with-key (resource-list-item (second %))
           (first %)) resources)])
