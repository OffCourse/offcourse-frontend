(ns offcourse.viewmodels.collection-view.index
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.collection-view.queryable :as qa-impl]
            [offcourse.viewmodels.collection-view.validatable :as va-impl]
            [offcourse.models.label :as lb :refer [Label]]
            [medley.core :as medley]
            [com.rpl.specter :refer [select-first ALL]]
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

(defn new [{:keys [type collection] :as as} {:keys [collections] :as ds}]
  (let [collection (qa/get ds :collection collection)
        labels     (medley/map-vals lb/collection->labels
                                    (qa/get ds :collection-names :all))
        courses    (qa/get ds :courses (:course-ids collection))]
    (->CollectionView type labels collection courses)))
