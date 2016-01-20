(ns offcourse.models.collection-view.queryable
  (:require [medley.core :as medley]
            [offcourse.models.label :as lb]))

(defn refresh [{:keys [collection] :as vm} {:keys [collections courses]}]
  (let [{:keys [collection-type collection-name]} collection
        collection (get-in collections [collection-type collection-name])]
    (merge vm {:collection collection
               :labels     (medley/map-vals (comp lb/collection->labels keys) collections)
               :courses    (keep #(get courses %) (:course-ids collection))})))
