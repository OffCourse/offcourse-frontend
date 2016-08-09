(ns offcourse.views.containers.checkpoint-container
  (:require [rum.core :as rum]))

(rum/defc checkpoint-container [{:keys [viewer-meta viewer]}]
  [:.checkpoint
   [:.checkpoint--section viewer]
   [:.checkpoint--section viewer-meta]])