(ns offcourse.views.components.snippets
  (:require [rum.core :as rum]))

(rum/defc snippet [{:keys [checkpoint-id resource task] :as checkpoint}]
  (println checkpoint)
  [:li.snippet {:key checkpoint-id}
   [:h1.title task]
   [:p (:title resource)]])

(rum/defc snippets [checkpoints]
  [:ul.snippets
   (map #(rum/with-key (snippet %) (:checkpoint-id %)) checkpoints)])
