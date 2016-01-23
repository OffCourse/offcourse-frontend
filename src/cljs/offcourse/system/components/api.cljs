(ns offcourse.system.components.api
  (:require [offcourse.api.index :as api]
            [offcourse.protocols.convertible :as ci]
            [com.stuartsierra.component :as component]
            [offcourse.protocols.queryable :as qa]))

(def actions   [:failed-fetch :fetched-data])

(def reactions {:not-found-data qa/fetch})

(def courses-fetchables
  {:courses          [ci/to-course :course-ids]
   :course           [ci/to-course]
   :collection       [ci/to-collection]
   :collection-names [identity]})

(def resources-fetchables
  {:resources          [ci/to-resource :resource-ids]
   :resource           [ci/to-resource]})

(def courses-component
  (component/using
   (api/new :courses-api actions reactions courses-fetchables)
   {:input-channel  :courses-input
    :output-channel :api-output
    :service        :courses-service}))

(def user-courses-component
  (component/using
   (api/new :user-courses-api actions reactions courses-fetchables)
   {:input-channel  :user-courses-input
    :output-channel :api-output
    :service        :user-courses-service}))

(def resources-component
  (component/using
   (api/new :resources-api actions reactions resources-fetchables)
    {:input-channel  :resources-input
     :output-channel :api-output
     :service        :resources-service}))
