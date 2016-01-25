(ns offcourse.system.components.data-service
  (:require [com.stuartsierra.component :as component]
            [offcourse.data-service.index :as data-service]
            [offcourse.protocols.queryable :as qa]))

(def actions   [:checked-store
                :not-found-data
                :refreshed-datastore])
(def reactions {:not-found-data qa/check
                :fetched-data   qa/refresh})
(def component
  (component/using
   (data-service/new actions reactions)
   {:input-channel  :data-service-input
    :output-channel :data-service-output
    :log-channel    :logger-input}))
