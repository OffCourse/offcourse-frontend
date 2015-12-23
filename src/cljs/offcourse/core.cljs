(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [offcourse.adapters.pouchdb :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.views.index :as views-service]
            [offcourse.fake-data.index :as fake-data]
            [offcourse.plumbing :as plumbing]))

(defn stringify [js-object]
  (.stringify js/JSON js-object))

(defn app [design-doc]
  (let [channels (plumbing/channels)
        bootstrap-doc (-> (fake-data/generate-course "123abbc")
                          (clj->js))]
    (component/system-map
     :api-input  (:api-input channels)
     :api-output (:api-output channels)
     :renderer-input (:renderer-input channels)
     :db (-> (pouchdb/new-db "Offcourse-Sample" design-doc bootstrap-doc))
     :api (component/using
           (api-service/new-api)
           {:input-channel :api-input
            :output-channel :api-output
            :service :db})
     :renderer (component/using
                (views-service/new-renderer)
                {:input-channel :renderer-input}))))
