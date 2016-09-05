(ns offcourse.views.components.viewer
  (:require [markdown.core :refer [md->html]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [resource]} _ _]
  [:.viewer
   (if-let [{:keys [title content]} resource]
     [:.viewer--content
      [:h1.title {:key :title} title]
      [:article {:key :content
                 :dangerouslySetInnerHTML {:__html (md->html content)}}]]
     [:.loading "This resource couldn't be found... yet..."])])
