(ns offcourse.system.components.data-service
  (:require [com.stuartsierra.component :as component]
            [offcourse.data-service.index :as data-service]))

(def component
  (component/using
   (data-service/new)
   {:input-channel  :data-service-input
    :output-channel :data-service-output}))
