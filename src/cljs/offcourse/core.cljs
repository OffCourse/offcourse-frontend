(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [adapters.pouchdb.index :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.views.index :as views-service]
            [offcourse.fake-data.index :as fake-data]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.plumbing :as plumbing]))

(defn stringify [js-object]
  (.stringify js/JSON js-object))

(defn app [design-doc]
  (let [channels (plumbing/channels)
        bootstrap-doc (-> (fake-data/generate-course "123abbc")
                          (clj->js))]
    (component/system-map
     :db (-> (pouchdb/new-db "Offcourse-Sample" [design-doc bootstrap-doc]))
     :api-input  (:api-input channels)
     :api-output (:api-output channels)
     :api-actions {:not-found-data qa/fetch}
     :api (component/using
           (api-service/new-api)
           {:input-channel :api-input
            :output-channel :api-output
            :actions :api-actions
            :service :db})
     :renderer-input (:renderer-input channels)
     :renderer (component/using
                (views-service/new-renderer)
                {:input-channel :renderer-input}))))
