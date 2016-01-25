(ns offcourse.system.components.logger
  (:require [offcourse.logger.index :as logger]
            [com.stuartsierra.component :as component]))

(def actions   [:updated-logs])
(def reactions {:logged-action println})

(def component
  (component/using
   (logger/new actions reactions)
   {:input-channel  :logger-input
    :output-channel :logger-output}))
