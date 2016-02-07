(ns offcourse.viewmodels.collection-view.index
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.collection-view.queryable :as qa-impl]
            [offcourse.viewmodels.collection-view.validatable :as va-impl]
            [offcourse.models.label :as lb :refer [Label]]
            [medley.core :as medley]
            [cljs.pprint :as pp]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
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

(def graph
  (graph/compile {:view-name  (fnk [[:appstate type]] type)
                  :collection (fnk [datastore [:appstate collection]]
                                   (or (qa/get datastore :collection collection) collection))
                  :labels     (fnk [datastore]
                                   (medley/map-vals lb/collection->labels
                                                    (qa/get datastore :collection-names :all)))
                  :courses    (fnk [datastore collection]
                                   (qa/get datastore :courses (:course-ids collection)))}))

(defn new [input]
  (map->CollectionView (graph input)))
