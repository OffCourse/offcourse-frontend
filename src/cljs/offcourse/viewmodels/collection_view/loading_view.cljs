(ns offcourse.viewmodels.collection-view.loading-view
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CheckpointView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     checkpoint-id :- schema/Num
     resource :- Resource]
  Validatable
  (-missing-data [vm] (va-impl/missing-data vm))
  (-valid? [vm] (if (qa/check vm) false true))
  Queryable
  (-check [vm] (schema/check CheckpointView vm))
  (-refresh [vm store] #_(qa-impl/refresh vm store)))

(def graph
  {:view-data     (fnk [appstate] (:view-data appstate))})

(def compose (graph/compile graph))

(defn dummy [{:keys [checkpoint-id] :as data}]
  {:type :loading-view})

(defn new [appstate datastore]
  (-> {:appstate appstate}
      compose
      map->CheckpointView))
