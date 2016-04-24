(ns offcourse.views.components.viewer
  (:require [markdown.core :refer [md->html]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [resource]}]
  (let [{:keys [content]} resource]
    [:.viewer
     (if content
       [:article.viewer--content {:dangerouslySetInnerHTML {:__html (md->html content)}}]
       [:.loading "Waiting"])]))
