(ns offcourse.core
  (:require [com.stuartsierra.component :as component]
            [OffcourseDesignDocs]
            [offcourse.adapters.pouchdb :as pouchdb]
            [offcourse.api.index :as api-service]
            [offcourse.views.index :as views-service]
            [offcourse.plumbing :as plumbing]
            [offcourse.views.debug :as debug]))

(defn app []
  (let [design-doc (.-course js/OffcourseDesignDocs)
        channels (plumbing/channels)]
    (component/system-map
     :api-input  (:api-input channels)
     :api-output (:api-output channels)
     :view-input (:view-input channels)
     :db (-> (pouchdb/new-db "Offcourse-Sample" design-doc))
     :api (component/using
           (api-service/new-api)
           {:input-channel :api-input
            :output-channel :api-output
            :service :db})
     :view (component/using
           (views-service/new-renderer)
           {:input-channel :view-input}))))

(defn render [response]
  (debug/render response))
