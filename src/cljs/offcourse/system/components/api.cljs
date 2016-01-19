(ns offcourse.system.components.api
  (:require [offcourse.api.index :as api]
            [offcourse.protocols.convertible :as ci]
            [com.stuartsierra.component :as component]))

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
   (api/new :courses-api)
   {:input-channel  :courses-input
    :output-channel :api-output
    :fetchables     :courses-fetchables
    :service        :courses-service}))

(def user-courses-component
  (component/using
   (api/new :user-courses-api)
   {:input-channel  :user-courses-input
    :output-channel :api-output
    :fetchables     :courses-fetchables
    :service        :user-courses-service}))

(def resources-component
  (component/using
   (api/new :resources-api)
    {:input-channel  :resources-input
     :output-channel :api-output
     :fetchables     :resources-fetchables
     :service        :resources-service}))
