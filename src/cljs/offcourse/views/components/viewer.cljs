(ns offcourse.views.components.viewer
  (:require [markdown.core :refer [md->html]]
            [rum.core :as rum]))

(rum/defc viewer [{:keys [content] :as resource}]
  [:.viewer
   (if content
     [:.content {:dangerouslySetInnerHTML {:__html (md->html content)}}]
     [:.loading "Waiting"])])
