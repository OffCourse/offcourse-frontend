(ns offcourse.styles.components.collection-panel
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [percent px]]]))

(defn collection-panels [{:keys [templates units fonts colors]}]
  [[:.collection-panels (merge (:component templates) {:background-color (:primary colors)})]])

(defn collection-panel [{:keys [templates units fonts colors]}]
  [[:.collection-panel (merge (:component templates) {:flex-direction :column
                                                      :height :auto
                                                      :padding (:full units)
                                                      :padding-top 0
                                                      :margin-bottom (:sixth units)})]
   [:.collection-panel--title {:margin-bottom (:tenth units)}
    [:.title {:font-family (:base fonts)
              :font-size   (:half units)}]]
   [:.labels {:display :block}]])
