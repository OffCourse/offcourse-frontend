(ns offcourse.models.collection-viewmodel
  (:require [schema.core :as schema :include-macros true]
             [offcourse.protocols.queryable :as qa :refer [Queryable]]
             [medley.core :as medley]
             [offcourse.models.course :refer [Course]]
             [offcourse.models.collection :refer [Collection]]
             [offcourse.protocols.validatable :as va :refer [Validatable]]))

(schema/defrecord CollectionViewmodel
    [view-name :- Keyword
     labels :- {Keyword schema/Any}
     collection :- Collection
     courses :- (schema/conditional #(not (nil? %)) [Course])]
  Validatable
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [{:keys [courses collection] :as vm}]
    (schema/check CollectionViewmodel vm))
  (refresh [{:keys [collection] :as vm} {:keys [collections courses] :as store}]
    (let [labels     (medley/map-vals keys collections)
          collection (get-in collections [(:collection-type collection)
                                          (:collection-name collection)])
          course-ids (:course-ids collection)
          courses    (map #(get courses %) course-ids)]
      (assoc vm :collection collection
                :labels labels
                :courses courses))))

(defn new [{:keys [collection] :as query}]
  (map->CollectionViewmodel {:view-name :collection-view
                             :collection collection}))
