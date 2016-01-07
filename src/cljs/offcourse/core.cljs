(ns offcourse.core
  (:require [cljs-uuid-utils.core :as uuid]
            [com.stuartsierra.component :as component]
            [offcourse.adapters.fakedb.index :as fakedb]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.fake-data.index :as fake-data]
            [offcourse.models.course :as co]
            [offcourse.plumbing :as plumbing]
            [offcourse.protocols.convertible :as ci :refer [Convertible]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
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
   {:input-channel :api-input
    :output-channel :api-output
    :actions :api-actions
    :courses-service :courses-service
    :resources-service :resources-service}))

(def debug-component
  (component/using
   (views-service/new-renderer)
   {:input-channel :renderer-input}))

(defn app [design-doc]
  (let [channels (plumbing/channels)
        bd (fake-data/generate-course)
        bootstrap-doc (clj->js (add-db-id bd))]
    (component/system-map
     :courses-service   (pouchdb/new-db :courses-db [design-doc bootstrap-doc])
     :resources-service (fakedb/new-db  :resources-db)
     :api-input         (:api-input channels)
     :api-output        (:api-output channels)
     :api-actions       {:not-found-data qa/fetch}
     :api               api-component
     :renderer-input    (:renderer-input channels)
     :renderer          debug-component)))
