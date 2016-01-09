(ns offcourse.core
  (:require [cljs-uuid-utils.core :as uuid]
            [com.stuartsierra.component :as component]
            [offcourse.adapters.fakedb.index :as fakedb]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.data-service.index :as data-service]
            [offcourse.fake-data.index :as fake-data]
            [offcourse.models.course :as co]
            [offcourse.plumbing :as plumbing]
            [offcourse.protocols.convertible :as ci :refer [Convertible]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.views.index :as views-service]))

(def ^:const doc-id "56886142-cce5-4a40-ba61-d1ff9c34cf9f")

(defn stringify [js-object]
  (.stringify js/JSON js-object))

#_(defn add-db-id [doc]
  (assoc doc :_id (str (:base-id doc))))

(defn add-db-id [doc]
  (assoc doc :_id  doc-id))

(def api-component
  (component/using
   (api-service/new-api)
   {:input-channel     :api-input
    :output-channel    :api-output
    :actions           :api-actions
    :courses-service   :courses-service
    :resources-service :resources-service}))

(def data-service-component
  (component/using
   (data-service/new-ds)
   {:input-channel  :data-service-input
    :output-channel :data-service-output
    :actions        :data-service-actions}))

(def debug-component
  (component/using
   (views-service/new-renderer)
   {:input-channel :renderer-input}))

(defn app [design-doc]
  (let [channels        (plumbing/channels)
        bd              (fake-data/generate-course)
        bootstrap-doc   (clj->js (add-db-id bd))
        courses-service (pouchdb/new-db :courses-db [design-doc bootstrap-doc])
        fakedb          (fakedb/new-db  :resources-db)]
    (component/system-map
     :user-output          (:user-output channels)
     :courses-service      courses-service
     :resources-service    fakedb
     :api-input            (:api-input channels)
     :api-output           (:api-output channels)
     :api-actions          {:data-service-initialized nil
                            :not-found-data qa/fetch}
     :api                  api-component
     :data-service-input   (:data-service-input channels)
     :data-service-output  (:data-service-output channels)
     :data-service-actions {:not-found-data qa/check
                            :fetched-data qa/refresh}
     :data-service         data-service-component
     :renderer-input       (:renderer-input channels)
     :renderer             debug-component)))
