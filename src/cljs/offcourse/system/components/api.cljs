(ns offcourse.system.components.api
  (:require [offcourse.api.index :as api]
            [com.stuartsierra.component :as component]))

(def component
  (component/using
   (api/new)
   {:input-channel     :api-input
    :output-channel    :api-output
    :courses-service   :courses-service
    :resources-service :resources-service}))
