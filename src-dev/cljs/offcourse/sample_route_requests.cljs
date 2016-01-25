(ns offcourse.sample-route-requests
  (:require [offcourse.sample-queries :as sq]))

(def payload
  {:collection-view {:type            :collection-view
                     :collection-type :flags
                     :collection-name :new}
   :course-view     {:type            :course-view
                     :course-id       (first sq/valid-course-ids)}
   :checkpoint-view {:type            :checkpoint-view
                     :course-id       (first sq/valid-course-ids)
                     :checkpoint-id   1}})

(def sample-request {:type :requested-route
                           :payload (:collection-view payload)})

(defn request [handler]
  {:type :requested-route
   :payload (handler payload)})
