(ns offcourse.models.viewmodel.index
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Viewmodel []
  Queryable
  (-refresh [vm _] {:type :error :error :query-not-supported}))

(defn new
  ([] (map->Viewmodel {})))
