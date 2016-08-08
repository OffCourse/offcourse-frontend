(ns offcourse.styles.shame
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden.arithmetic :refer [*]]
            [garden.units :as u :refer [percent px rem]]
            [offcourse.styles.vocabulary :as v]))

(defn shame [{:keys [templates borders colors fonts units]}]
  [[:.checkpoint           (merge (:paper              templates)
                                  {:width             (percent 100)})]
   [:.meta                 (merge (:column-component      templates)
                                  (:paper              templates)
                                  {:align-items        :flex-start
                                   :padding         [[(:full units) (:full units) 0 (:full units)]]
                                   :max-width         (:max-content-width units)})]
   [:.meta--list           (merge (:column-component   templates)       
                                  (:recycled-paper     templates)
                                  (:border-quotes      templates)
                                  {:padding          [[(:full units) (:three units) (:full units) (:full units)]]})]
   [:.meta--list-item      (merge (:smalltitle         templates)
                                  {})]       
   [:.meta--labels                {:padding          [[(:full units) 0 0 0]]}]])
