(ns offcourse.styles.components.viewer
  (:require [offcourse.styles.vocabulary :as v]))

(defn viewer [{:keys [templates colors fonts units]}]
  [[v/viewer  (merge (:column-component templates)
                     (:paper templates)
                     {:overflow-y :auto
                      :flex 1})]
   [v/viewer--content {:display      :block
                       :max-width    (:max-content-width units)
                       :padding      (:full units)}
    [v/viewer-header (:banner templates)]
    [v/viewer-text (:text templates)]]])
