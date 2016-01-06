(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.views.index :as views-service]
            [offcourse.models.course :as co]
            [offcourse.fake-data.index :as fake-data]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.convertible :as ci :refer [Convertible]]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.plumbing :as plumbing]))

(defn stringify [js-object]
  (.stringify js/JSON js-object))

#_(defn add-db-id [doc]
  (assoc doc :_id (str (:base-id doc))))

(defn add-db-id [doc]
  (assoc doc :_id  "56886142-cce5-4a40-ba61-d1ff9c34cf9f"))

(defn app [design-doc]
  (let [channels (plumbing/channels)
        bd (fake-data/generate-course)
        bootstrap-doc (->> bd
                           add-db-id
                           clj->js)]
    (component/system-map
     :courses-db (-> (pouchdb/new-db "CoursesDB" [design-doc bootstrap-doc]))
     :api-input     (:api-input channels)
     :api-output    (:api-output channels)
     :api-actions   {:not-found-data qa/fetch}
     :api (component/using
           (api-service/new-api)
           {:input-channel :api-input
            :output-channel :api-output
            :actions :api-actions
            :service :courses-db})
     :renderer-input (:renderer-input channels)
     :renderer (component/using
                (views-service/new-renderer)
                {:input-channel :renderer-input}))))
