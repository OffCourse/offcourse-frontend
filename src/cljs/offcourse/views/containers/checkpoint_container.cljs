(ns offcourse.views.containers.checkpoint-container
  (:require [rum.core :as rum]))

(rum/defc checkpoint-container [{:keys [sheet viewer]}]
  [:.checkpoint
   [:.checkpoint--section sheet]
   [:.checkpoint--section viewer]])

