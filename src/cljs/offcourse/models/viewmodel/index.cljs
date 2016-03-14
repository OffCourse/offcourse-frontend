(ns offcourse.models.viewmodel.index
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.models.viewmodel.refresh :as refresh-impl]))

(schema/defrecord Viewmodel
    [type :- schema/Keyword
     dependencies :- {schema/Keyword schema/Any}]
  Queryable
  (-get [vm query] (get-in vm [:dependencies :course]))
  (-refresh [vm query] (refresh-impl/refresh vm query)))

(defn new
  ([defaults] (map->Viewmodel defaults))
  ([] (map->Viewmodel {})))
