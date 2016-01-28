(ns offcourse.datastore.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.datastore.lifecycle :as lc-impl]
            [offcourse.datastore.queryable :as qa-impl]
            [offcourse.datastore.validatable :as va-impl]
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
  (start   [ds] (lc-impl/start ds))
  (stop    [ds] (lc-impl/stop ds))
  Queryable
  (check   [ds query] (qa-impl/check ds query))
  (refresh [ds query] (qa-impl/refresh ds query))
  Validatable
  (valid?  [ds] (va-impl/valid? ds))
  Responsive
  (respond [ds status payload] (ri/-respond ds status payload))
  (listen [ds] (ri/-listen ds)))

(defn new [] (map->Datastore {:component-name :datastore}))
