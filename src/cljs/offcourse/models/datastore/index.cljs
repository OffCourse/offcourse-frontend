(ns offcourse.models.datastore.index
  (:require [offcourse.models.collection :refer [Collection]]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.datastore.add :as add-impl]
            [offcourse.models.datastore.check :as check-impl]
            [offcourse.models.datastore.get :as get-impl]
            [offcourse.models.datastore.refresh :as refresh-impl]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(schema/defrecord Datastore
    [collections           :- [Collection]
     courses               :- [Course]
     resources             :- (schema/maybe {schema/Str Resource})]
  Validatable
  (-valid?   [ds] (empty? (schema/check Datastore ds)))
  Queryable
  (-add     [ds query] (add-impl/add ds query))
  (-get     [ds query] (get-impl/get ds query))
  (-check   [ds query] (check-impl/check ds query))
  (-refresh [ds query] (refresh-impl/refresh ds query)))

(defn new
  ([] (->Datastore [] [] {}))
  ([ds-data] (map->Datastore ds-data)))
