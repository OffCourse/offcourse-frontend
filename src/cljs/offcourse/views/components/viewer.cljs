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
  [:.meta {:key checkpoint-id}
   [:ul.meta--list {:key :meta}
    [:li.meta--list-item {:data-item-type :todo
                          :key :task}
     [:a {:key :title
          :href (checkpoint-url checkpoint-slug)}
      [:span task]]]
    [:li.meta--list-item {:key :source} "Source: Smashing Magazine"]
    [:li.meta--list-item {:key :author} "Author: John Doehingy"]
    [:li.meta--list-item {:key :date} "Date: 05-08-2019"]]
   [:.meta--labels {:key :labels} (labels (map (fn [tag] {:label-name tag}) tags) url-helpers)]])
