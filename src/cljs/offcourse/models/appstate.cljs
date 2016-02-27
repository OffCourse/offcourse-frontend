(ns offcourse.models.appstate
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.models.datastore.index :as ds :refer [Datastore]]))

(schema/defrecord Appstate
    [type           :- schema/Keyword
     data-deps      :- {schema/Keyword schema/Any}
     store          :- Datastore]
  Validatable
  (-valid? [as] (if-not (schema/check Appstate as) true false))
  Queryable
  (-refresh [{:keys [store]} query] (qa/refresh store query)))

(defn new
  ([] (->Appstate :loading-view nil (ds/new)))
  ([view-type & data]
   (let [data (apply hash-map data)]
     (map->Appstate {:type view-type
                     :store (:store data)
                     :data-deps (dissoc data :store)}))))
