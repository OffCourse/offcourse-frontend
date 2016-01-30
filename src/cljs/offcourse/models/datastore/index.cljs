(ns offcourse.models.datastore.index
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.models.datastore.implementations.check :as check-impl]
            [offcourse.models.datastore.implementations.refresh :as refresh-impl]
            [offcourse.models.resource :refer [Resource]]
            [schema.core :as schema]))

(schema/defrecord Datastore
    [collections           :- {(schema/enum :flags :tags :curators) schema/Any}
     courses               :- {schema/Str Course}
     resources             :- {schema/Str Resource}
     has-collection-names? :- schema/Bool]
  Validatable
  (valid? [this] (:has-collection-names? this))
  Queryable
  (check [this query] (check-impl/check this query))
  (refresh [this query] (refresh-impl/refresh this query)))

(defn new []
  (map->Datastore {}))
