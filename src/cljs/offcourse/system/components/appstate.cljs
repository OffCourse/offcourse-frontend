(ns offcourse.system.components.appstate
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]))

(def component
  (component/using
   (appstate/new)
   {:input-channel  :appstate-input
    :output-channel :appstate-output
    :viewmodels     :viewmodels}))
