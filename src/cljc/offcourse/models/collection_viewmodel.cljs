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
  (missing-data [{:keys [collection] :as vm}]
    (let [{:keys [collection-name collection-type course-ids]} collection
          next-field (first (keys (qa/check vm)))
          payload {:type next-field}]
      (when next-field
        (case next-field
          :labels     (assoc payload :type :collection-names)
          :collection (assoc payload :collection-name collection-name
                             :collection-type collection-type)
          :courses    (assoc payload :course-ids course-ids)))))
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

(defn new [{:keys [type collection-name collection-type] :as q}]
  (let [collection {:collection-name collection-name
                    :collection-type collection-type}]
  (map->CollectionViewmodel {:view-name type
                             :collection collection})))
