(ns offcourse.views.components.viewer
  (:require [markdown.core :refer [md->html]]
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
