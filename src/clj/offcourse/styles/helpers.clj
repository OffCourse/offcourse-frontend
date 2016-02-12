(ns offcourse.styles.helpers
  (:require [medley.core :as medley]))

(defn augment [template overrides]
  (merge template overrides))

(defn augment-many [template overrides]
  (->> overrides
       (into {})
       (medley/map-vals #(augment template %))
       (into [])))
