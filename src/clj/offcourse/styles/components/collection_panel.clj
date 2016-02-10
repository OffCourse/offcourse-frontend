(ns offcourse.styles.components.collection-panel
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [px]]]))

(defn collection-panel [{:keys [base-component base-font]}]
  [:.collection-panel__title
   [:.title {:font-family base-font
             :font-size (px 16)}]])
