(ns offcourse.datastore.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.datastore.queryable :as qa-impl]
            [offcourse.datastore.validatable :as va-impl]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(schema/defrecord Datastore
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start   [ds] (ri/listen (assoc ds :store (atom (ds/new)))))
  (stop    [ds] (ri/mute ds))
  Queryable
  (-check   [ds query] (qa-impl/check ds query))
  (-modify  [ds query] (qa-impl/modify ds query))
  (refresh [ds query] (qa-impl/refresh ds query))
  Validatable
  (valid?  [ds] (va-impl/valid? ds))
  Responsive
  (respond [ds status payload] (ri/-respond ds status payload))
  (mute [ds] (ri/-mute ds))
  (listen [ds] (ri/-listen ds)))

(defn new [] (map->Datastore {:component-name :datastore}))
