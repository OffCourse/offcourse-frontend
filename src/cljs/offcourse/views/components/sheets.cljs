(ns offcourse.views.components.sheets
  (:require [markdown.core :refer [md->html]]
            [rum.core :as rum]
            [cuerdas.core :as str]))

(rum/defc sheet [{:keys [checkpoint-id checkpoint-slug content url resource task] :as checkpoint}
                 {:keys [checkpoint-url]}]
  (let [content (-> (:content resource)
                    (str/slice 0 500)
                    (str/prune 20))]
    [:a.sheet {:key checkpoint-id
               :href (checkpoint-url checkpoint-slug)}
     [:.sheet--section {:key :meta}
      [:.list
       [:h1.list--item {:key :task} task]
       [:p.list--item {:key :url} url]]]
     [:.sheet--section {:key :content}
      [:article.content {:dangerouslySetInnerHTML {:__html (md->html content)}}]]]))

(rum/defc sheet-container [checkpoint url-helpers]
  [:.container (sheet checkpoint url-helpers)])

(rum/defc sheets [checkpoints url-helpers]
  [:.sheets
   (map #(rum/with-key (sheet-container % url-helpers) (:checkpoint-id %)) checkpoints)])
