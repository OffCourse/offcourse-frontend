(ns offcourse.models.dependencies.index
  (:require [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.models.dependencies.refresh :as refresh-impl]
            [schema.core :as schema]))

(schema/defrecord Dependencies
    [course :- schema/Any]
  Queryable
  (-refresh [dependencies query] (refresh-impl/refresh dependencies query)))

(defn new
  ([] (map->Dependencies {}))
  ([overrides] (map->Dependencies overrides)))
