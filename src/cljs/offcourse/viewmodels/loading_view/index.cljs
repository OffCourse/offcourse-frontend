(ns offcourse.viewmodels.loading-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
            [schema.core :as schema :include-macros true]))

(schema/defrecord LoadingView
    [view-name :- Keyword]
  Validatable
  (-missing-data [vm] (va-impl/missing-data vm))
  (-valid? [vm] (if (qa/check vm) false true))
  Queryable
  (-check [vm] (schema/check LoadingView vm))
  (-refresh [vm store] #_(qa-impl/refresh vm store)))

(def graph
  {:view-name     (fnk [appstate] (:view-type appstate))})

(def compose (graph/compile graph))

(defn dummy [{:keys [checkpoint-id] :as data}]
  {:type :loading-view})

(defn new [appstate datastore]
  (-> {:appstate appstate}
      compose
      map->LoadingView))
