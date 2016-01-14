(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.fakedb.index :as fakedb]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.api.index :as api]
            [offcourse.appstate.index :as appstate]
            [offcourse.data-service.index :as data-service]
            [offcourse.plumbing :as plumbing]
            [offcourse.views.index :as views-service]
            [offcourse.models.collection-view.index :as clv]
            [offcourse.models.course-view.index :as cov]))

(def viewmodels {:collection-view clv/new
                 :course-view cov/new})


(def api-component
  (component/using
   (api/new)
   {:input-channel     :api-input
    :output-channel    :api-output
    :courses-service   :courses-service
    :resources-service :resources-service}))

(def data-service-component
  (component/using
   (data-service/new)
   {:input-channel  :data-service-input
    :output-channel :data-service-output}))

(def appstate-component
  (component/using
   (appstate/new)
   {:input-channel  :appstate-input
    :output-channel :appstate-output
    :viewmodels     :viewmodels}))

(def debug-component
  (component/using
   (views-service/new-renderer)
   {:input-channel :renderer-input}))

(defn app [bootstrap-docs]
  (let [channels        (plumbing/channels)
        courses-service (pouchdb/new-db :courses-db bootstrap-docs)
        fakedb          (fakedb/new-db  :resources-db)]
    (component/system-map
     :viewmodels           viewmodels
     :user-output          (:user-output channels)
     :courses-service      courses-service
     :resources-service    fakedb
     :api-input            (:api-input channels)
     :api-output           (:api-output channels)
     :api                  api-component
     :data-service-input   (:data-service-input channels)
     :data-service-output  (:data-service-output channels)
     :data-service         data-service-component
     :appstate-input       (:appstate-input channels)
     :appstate-output      (:appstate-output channels)
     :appstate             appstate-component
     :renderer-input       (:renderer-input channels)
     :renderer             debug-component)))
