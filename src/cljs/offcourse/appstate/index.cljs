(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [medley.core :as medley]
            [offcourse.models.collection-viewmodel :as clvm]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.composable :as ca :refer [Composable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.appstate.lifecycle :as lc-impl]
            [offcourse.appstate.composable :as ca-impl]
            [offcourse.appstate.queryable :as qa-impl]))

(def actions [:updated-viewmodel])

(def reactions {:requested-route qa/refresh
                :checked-store ca/compose
                :refreshed-datastore ca/compose})

(defrecord Appstate [component-name viewmodels input-channel
                     output-channel actions reactions initialized?]
  Lifecycle
  (start [as] (lc-impl/start as))
  (stop [as] (lc-impl/stop as))
  Queryable
  (refresh [as query] (qa-impl/refresh as query))
  Responsive
  (respond [as status payload] (ri/-respond as status payload))
  (listen [as] (ri/-listen as))
  Composable
  (compose [as] (ca-impl/compose as))
  (compose [as query] (ca-impl/compose as query)))

(defn new []
  (map->Appstate {:component-name :appstate
                  :actions actions
                  :reactions reactions
                  :initialized? (atom false)}))
