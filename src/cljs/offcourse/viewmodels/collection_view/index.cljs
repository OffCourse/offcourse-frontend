(ns offcourse.viewmodels.collection-view.index
  (:require [offcourse.models.collection :refer [Collection]]
            [offcourse.viewmodels.collection-view.queryable :as qa-impl]
            [offcourse.viewmodels.collection-view.validatable :as va-impl]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [medley.core :as medley]
            [com.rpl.specter :refer [select-first ALL]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CollectionView
    [view-name  :- Keyword
     labels     :- {Keyword #{Label}}
     collection :- Collection
     courses    :- (schema/conditional #(not (nil? %)) [Course])]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CollectionView vm))
  (refresh [vm store] #_(qa-impl/refresh vm store)))

(defn course-by-id [courses id]
  (select-first [ALL #(= (:course-id %) id)] courses))

(defn new
  ([{:keys [type collection] :as view-data}
    {:keys [collections courses] :as store}]
   (let [{:keys [collection-type collection-name]} collection
         collection-query {:type :collection :collection collection}
         {:keys [course-ids] :as collection} (qa/get store collection-query)
         labels (medley/map-vals (comp lb/collection->labels keys) collections)
         courses (when courses (keep #(course-by-id courses %) course-ids))]

