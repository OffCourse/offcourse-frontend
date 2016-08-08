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
  [:.sheet {:key checkpoint-id}
   [:.sheet--section {:key :meta}
    [:.list {:key :list}
     [:.list--item {:data-item-type :todo
                    :key :task}
      (when trackable? [:button.button {:key :checkbox
                                        :data-button-type :checkbox
                                        :on-click #(toggle-checkpoint checkpoint %1)
                                        :disabled (not trackable?)
                                        :data-selected (boolean completed?)} nil])
      [:a {:key :title
           :href (checkpoint-url checkpoint-slug)}
       [:span task]]]
     [:.list--item {:key :source} "Source: Smashing Magazine"]
     [:.list--item {:key :author} "Author: John Doehingy"]
     [:.list--item {:key :date} "Date: 05-08-2019"]]
    [:div {:key :labels} (labels (map (fn [tag] {:label-name tag}) tags) url-helpers)]]
   [:.sheet--section {:key :button}
    [:button.coolbutton {:key :source-button} "View on Source"]]])
