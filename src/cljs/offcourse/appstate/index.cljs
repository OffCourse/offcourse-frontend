(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.lifecycle :as lc]
            [offcourse.models.collection-viewmodel :as clvm]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]))

(def actions [:updated-viewmodel])

(def reactions {:requested-route qa/check
                :checked-store qa/refresh
                :refreshed-datastore qa/refresh})

(def viewmodels {:collection clvm/new})

(defrecord Appstate [component-name input-channel output-channel actions reactions initialized?]
  Lifecycle
  (start [as] (lc/start as))
  (stop [as] (lc/stop as))
  Queryable
  (check [as {:keys [type] :as query}]
    (ri/respond as :not-found-data ((type viewmodels) query)))
  (refresh [as query]
    (ri/respond as :updated-viewmodel {:proposed-viewmodel query}))
  Responsive
  (respond [as status payload] (ri/-respond as status payload))
  (listen [as] (ri/-listen as)))

(defn new []
  (map->Appstate {:component-name :appstate
                  :actions actions
                  :reactions reactions
                  :initialized? (atom false)}))
