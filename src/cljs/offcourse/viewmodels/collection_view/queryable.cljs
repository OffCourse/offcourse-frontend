(ns offcourse.viewmodels.collection-view.queryable
  (:require [medley.core :as medley]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [offcourse.models.label :as lb]))

(defn course-by-id [course-id]
  [ALL #(= (:course-id %) course-id)])

(defn refresh [{:keys [collection] :as vm} {:keys [collections courses]}]
  (let [{:keys [collection-type collection-name]} collection
        collection (or (get-in collections [collection-type collection-name])
                       collection)]
    (merge vm {:collection collection
               :labels     (medley/map-vals (comp lb/collection->labels keys) collections)
               :courses    (when courses
                             (keep #(select-first (course-by-id %) courses)
                                   (:course-ids collection)))})))
