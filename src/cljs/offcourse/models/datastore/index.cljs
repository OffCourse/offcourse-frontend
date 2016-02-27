(ns offcourse.models.datastore.index
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.models.datastore.check :as check-impl]
            [offcourse.models.datastore.add :as add-impl]
            [offcourse.models.datastore.refresh :as refresh-impl]
            [offcourse.models.datastore.get :as get-impl]
            [offcourse.models.datastore.valid :as valid-impl]
            [offcourse.models.resource :refer [Resource]]
            [schema.core :as schema]
            [offcourse.protocols.queryable :as qa]))

(schema/defrecord Datastore
    [appstate              :- []
     collections           :- []
     courses               :- [Course]
     resources             :- {schema/Str Resource}
     collection-names      :- {schema/Any schema/Any}]
  Validatable
  (-valid?   [ds] (valid-impl/valid? ds))
  Queryable
  (-add     [ds query] (add-impl/add ds query))
  (-get     [ds query] (get-impl/get ds query))
  (-check   [ds query] (check-impl/check ds query))
  (-refresh [ds query] (refresh-impl/refresh ds query)))

(defn new
  ([] (->Datastore {} [] [] {} nil))
  ([ds-data] (map->Datastore ds-data)))
