(ns offcourse.views.components.sheets
  (:require [markdown.core :refer [md->html]]
            [offcourse.views.components.label :refer [labels]]
            [rum.core :as rum]
            [cuerdas.core :as str]))

(rum/defc sheet [{:keys [checkpoint-id completed? tags checkpoint-slug content url resource task] :as checkpoint}
                 {:keys [checkpoint-url] :as url-helpers}
                 {:keys [toggle-checkpoint]}
                 trackable?]
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
     [:.list--item {:key :url} url]]
    [:div {:key :labels} (labels (map (fn [tag] {:label-name tag}) tags) url-helpers)]]
   [:a.sheet--section {:key :content
                       :href (checkpoint-url checkpoint-slug)}
    [:article.content {}
     [:h1.title (:title resource)]
     [:p (:description resource)]]]])

(rum/defc sheet-container [checkpoint url-helpers handlers trackable?]
  [:.container (sheet checkpoint url-helpers handlers trackable?)])

(rum/defc sheets [checkpoints url-helpers handlers trackable?]
  [:.sheets
   (map #(rum/with-key (sheet-container % url-helpers handlers trackable?) (:checkpoint-id %)) checkpoints)])
