(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent px rem]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units]}]
  [[:.checkpoint           (merge (:row-component      templates)
                                  {:width             (percent 100)})]
   [:.meta--container      (merge {:padding           [[(:full units) 0 0 0]]
                                   :max-width         (:max-content-width units)})]
   [:.meta                 (merge (:column-component   templates)
                                  {:justify-content    :flex-start
                                   :padding         [[(:full units)]]})]
   [:.meta--section        (merge (:column-component   templates))]
   [:.meta--list           (merge (:column-component   templates)       
                                  {})]
   [:.meta--list-item      (merge {:padding          [[0 0 (:third units) 0]]})]
   [:.meta--title          (merge (:label              templates))]
   [:.meta--field          (merge (:smalltitle         templates))]
   [:.meta--labels         (merge (:column-component   templates))]])
