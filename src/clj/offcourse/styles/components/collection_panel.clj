(ns offcourse.styles.components.collection-panel
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [px]]]))

(defn collection-panel [{:keys [templates units fonts]}]
  [[:.collection-panel (merge (:component templates) {:flex-direction :column
                                                      :height :auto
                                                      :margin-bottom (:sixth units)})]
   [:.collection-panel__title {:margin-bottom (:tenth units)}
    [:.title {:font-family (:base fonts)
              :font-size   (:half units)}]]
   [:.labels {:display :block}]])
