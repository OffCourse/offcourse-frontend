(ns offcourse.system.components.appstate
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]
            [offcourse.protocols.queryable :as qa]
            [offcourse.system.viewmodels :refer [viewmodels]]
            [offcourse.protocols.composable :as ca]))

(def actions [:updated-viewmodel])

(def reactions {:requested-route qa/refresh
                :checked-store ca/compose
                :refreshed-datastore ca/compose})

(def component
  (component/using
   (appstate/new actions reactions viewmodels)
   {:input-channel  :appstate-input
    :output-channel :appstate-output}))
