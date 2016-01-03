(ns offcourse.main
  (:require [cljs.core.async :refer [<! put!]]
            [OffcourseDesignDocs]
            [offcourse.protocols.queryable :as qa]
            [com.stuartsierra.component :as component]
            [offcourse.core :as core])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def sample-payload
  #_{:type :course
     :course {:course-id "56899a8c-ffb9-42f4-b6f6-7bdc2cf98948/r2j2/1"}}
  #_{:type :courses
     :courses ["56899a8c-ffb9-42f4-b6f6-7bdc2cf98948/r2j2/1"
               "5689ab1c-a19b-4fa8-be4d-cac87da9c653/charlotte/1"]}
  #_{:type :collection
     :collection {:collection-type :curators
                  :collection-name :charlotte}}
  #_{:type :collection
     :collection {:collection-type :flags
                  :collection-name :new}}
  {:type :collection
   :collection {:collection-type :tags
                :collection-name :scalability}}
  #_{:type :collection-names})

(def sample-query {:type :not-found-data
                   :payload sample-payload})

(defonce app (atom nil))

(defonce design-doc (.-course js/OffcourseDesignDocs))

(defn init []
  (do
    (enable-console-print!)
    (reset! app (core/app design-doc))
    (reset! app (component/start @app))
    (put! (:api-input @app) sample-query)))

(defn reload []
  (do
    (enable-console-print!)
    (put! (:api-input @app) sample-query)
    (println "Re-Entering hyperspace...!!")))

(defn stop []
  (component/stop @app))
