(ns offcourse.viewmodels.collection-view.index
  (:require [medley.core :as medley]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.collection-view.validatable :as va-impl]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CollectionView
    [view-name  :- Keyword
     collection :- Collection
     courses    :- (schema/conditional #(not (nil? %)) [Course])]
  Validatable
  (-missing-data [vm] (va-impl/missing-data vm))
  (-valid? [vm] (if (qa/check vm) false true))
  Queryable
  (-check [vm] (schema/check CollectionView vm))
  (-refresh [vm store] #_(qa-impl/refresh vm store)))

(defn augment-course [selected {:keys [checkpoints] :as course}]
  (let [tags (-> (co/get-tags course)
                 (lb/collection->labels selected))]
    (-> course (with-meta {:tags tags}))))

(def graph
  {:view-data       (fnk [appstate] (:view-data appstate))
   :view-name       (fnk [appstate] (:view-type appstate))
   :collection-data (fnk [view-data] (:collection view-data))
   :collection      (fnk [appstate collection-data]
                         (or (qa/get appstate :collection collection-data)
                             collection-data))
   :course-ids      (fnk [collection] (:course-ids collection))
   :courses         (fnk [appstate course-ids collection]
                         (some->> (qa/get appstate :courses course-ids)
                                  (map (partial augment-course
                                                (:collection-name collection)))))})

(def compose (graph/compile graph))

(defn dummy [collection] {:view-type :collection-view
                          :view-data {:type :collection
                                      :collection collection}})

(defn new [appstate]
  (-> {:appstate appstate}
      compose
      map->CollectionView))
