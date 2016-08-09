(ns offcourse.views.components.viewer
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [resource]}]
  (let [{:keys [title content]} resource]
    [:.viewer
     (if content
       [:.viewer--content
        [:h1.title {:key :title} title]
        [:article {:key :content
                   :dangerouslySetInnerHTML {:__html (md->html content)}}]]
       [:.loading "Waiting"])]))

(rum/defc viewer-meta [{:keys [checkpoint-id completed? tags checkpoint-slug content url resource task] :as checkpoint}
                       {:keys [checkpoint-url] :as url-helpers}
                       {:keys [toggle-checkpoint]}
                       trackable?]
  ; (println "Logging:")
  ; (println (keys checkpoint))
  [:.meta--container
   [:.meta
    [:.meta--section
     [:ul.meta--list
      [:li.meta--list-item {:data-item-type :todo
                            :key            :task}
       [:a {:key   :title
            :href (checkpoint-url checkpoint-slug)}
        [:h6.meta--title "Task: "]
        [:span.meta--field task]]]
      [:li.meta--list-item
       [:h6.meta--title "Source: "]
       [:span.meta--field "Smashing Magazine"]]
      [:li.meta--list-item 
       [:h6.meta--title "Author: "]
       [:span.meta--field "John Doehingy"]]
      [:li.meta--list-item
       [:h6.meta--title "Date: "]
       [:span.meta--field "05-08-2019"]]]]]])
