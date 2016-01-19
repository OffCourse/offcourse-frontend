(ns offcourse.system.components.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.system.components.api :as api]
            [offcourse.system.components.appstate :as appstate]
            [offcourse.system.components.data-service :as data-service]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.viewmodels :refer [viewmodels]]
            [offcourse.views.index :as views-service]))

(def debug-component
  (component/using
   (views-service/new-renderer)
   {:input-channel :renderer-input}))

(defn system [bootstrap-docs databases]
  (let [channels (plumbing/channels)]
    (component/system-map
     :viewmodels           viewmodels
     :user-output            (:user-output channels)
     :courses-service        (:courses databases)
     :user-courses-service   (:user-courses databases)
     :resources-service      (:resources databases)
     :courses-input          (:courses-input channels)
     :user-courses-input     (:user-courses-input channels)
     :resources-input        (:resources-input channels)
     :api-output             (:api-output channels)
     :courses-fetchables     api/courses-fetchables
     :resources-fetchables   api/resources-fetchables
     :user-courses           api/user-courses-component
     :courses                api/courses-component
     :resources              api/resources-component
     :data-service-input     (:data-service-input channels)
     :data-service-output    (:data-service-output channels)
     :data-service           data-service/component
     :appstate-input         (:appstate-input channels)
     :appstate-output        (:appstate-output channels)
     :appstate               appstate/component
     :renderer-input         (:renderer-input channels)
     :renderer               debug-component)))
