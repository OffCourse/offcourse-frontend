(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [OffcourseDesignDocs]
            [offcourse.adapters.pouchdb :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.views.index :as views-service]
            [offcourse.plumbing :as plumbing]))

(defn app []
  (let [design-doc (.-course js/OffcourseDesignDocs)
        channels (plumbing/channels)]
    (component/system-map
     :api-input  (:api-input channels)
     :api-output (:api-output channels)
     :renderer-input (:renderer-input channels)
     :db (-> (pouchdb/new-db "Offcourse-Sample" design-doc))
     :api (component/using
           (api-service/new-api)
           {:input-channel :api-input
            :output-channel :api-output
            :service :db})
     :renderer (component/using
                (views-service/new-renderer)
                {:input-channel :renderer-input}))))
