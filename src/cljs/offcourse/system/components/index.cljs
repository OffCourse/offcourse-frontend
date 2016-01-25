(ns offcourse.system.components.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.system.components.api :as api]
            [offcourse.system.components.appstate :as appstate]
            [offcourse.system.components.data-service :as data-service]
            [offcourse.system.components.router :as router]
            [offcourse.system.components.logger :as logger]
            [offcourse.system.components.renderer :as renderer]
            [offcourse.system.plumbing :as plumbing]))

(defn system [bootstrap-docs databases]
  (let [channels (plumbing/channels)]
    (component/system-map
     :router-output          (:router-output channels)
     :logger-input           (:logger-input channels)
     :logger-output          (:logger-output channels)
     :courses-service        (:courses databases)
     :user-courses-service   (:user-courses databases)
     :resources-service      (:resources databases)
     :courses-input          (:courses-input channels)
     :user-courses-input     (:user-courses-input channels)
     :resources-input        (:resources-input channels)
     :api-output             (:api-output channels)
     :data-service-input     (:data-service-input channels)
     :data-service-output    (:data-service-output channels)
     :appstate-input         (:appstate-input channels)
     :appstate-output        (:appstate-output channels)
     :renderer-input         (:renderer-input channels)
     :router                 router/component
     :logger                 logger/component
     :user-courses           api/user-courses-component
     :courses                api/courses-component
     :resources              api/resources-component
     :data-service           data-service/component
     :appstate               appstate/component
     :renderer               renderer/component)))
