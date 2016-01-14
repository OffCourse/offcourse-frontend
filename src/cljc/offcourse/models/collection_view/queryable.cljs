(ns offcourse.models.collection-view.queryable
  (:require [medley.core :as medley]))

(defn refresh [{:keys [collection] :as vm} {:keys [collections courses] :as store}]
  (let [labels     (medley/map-vals keys collections)
        collection (get-in collections [(:collection-type collection)
                                        (:collection-name collection)])
        course-ids (:course-ids collection)
        courses    (map #(get courses %) course-ids)]
    (assoc vm :collection collection
           :labels labels
           :courses courses)))
