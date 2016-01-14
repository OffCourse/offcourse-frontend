(ns offcourse.sample-route-requests
  (:require [offcourse.sample-queries :as sq]))

(def payload
  {:collection-view {:type            :collection-view
                    :collection-type :flags
                    :collection-name :new}
  :course-view     {:type      :course-view
                    :course-id (first sq/valid-course-ids)}})

(def sample-request {:type :requested-route
                           :payload (:course-view payload)})
