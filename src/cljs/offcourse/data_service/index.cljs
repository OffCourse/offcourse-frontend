(ns offcourse.data-service.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.data-service.lifecycle :as lc-impl]
            [offcourse.data-service.queryable :as qa-impl]
            [offcourse.data-service.validatable :as va-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]))

(defrecord Datastore [component-name input-channel output-channel actions reactions initialized?]
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

(defn new [actions reactions]
  (map->Datastore {:component-name :data-service
                   :actions        actions
                   :reactions      reactions
                   :initialized?   (atom false)}))
