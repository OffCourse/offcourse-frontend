(ns offcourse.models.collection-view.index
  (:require [offcourse.models.collection :refer [Collection]]
            [offcourse.models.collection-view.queryable :as qa-impl]
            [offcourse.models.collection-view.validatable :as va-impl]
            [offcourse.models.course :refer [Course]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CollectionView
    [view-name :- Keyword
     labels :- {Keyword schema/Any}
     collection :- Collection
     courses :- (schema/conditional #(not (nil? %)) [Course])]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CollectionView vm))
  (refresh [vm store] (qa-impl/refresh vm store)))

(defn new [{:keys [type collection-name collection-type]}]
  (let [collection {:collection-name collection-name
                    :collection-type collection-type}]
  (map->CollectionView {:view-name  type
                        :collection collection})))
