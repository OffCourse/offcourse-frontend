(ns offcourse.sample-queries)

(def valid-course-ids ["569828dc-18cf-4584-9339-c266e2813987/yeehaa/1"])
(def invalid-course-ids ["5689ab1c-a19b-4fa8-be4d-cac87da9c653/charlotte/1"])
(def course-ids (concat valid-course-ids invalid-course-ids))

(def valid-resource-ids ["568da288-28b3-4bde-b4d8-38b3edcf5b4d"
                         "5689ab1c-a19b-4fa8-be4d-cac87da9c653"])
(def invalid-resource-ids ["568da288-28b3-4bde-b4edcf5b4d"])

(def payload
  {:resource   {:type :resource
                :resource-id (first valid-resource-ids)}
   :resources  {:type :resources
                :resource-ids valid-resource-ids}
   :course     {:type :course
                :course-id (first valid-course-ids)}
   :courses    {:type :courses
                :course-ids valid-course-ids}
   :curators   {:type :collection
                :collection-type :curators
                :collection-name :charlotte}
   :flags      {:type :collection
                :collection-type :flags
                :collection-name :featured}
   :tags       {:type :collection
                :collection-type :tags
                :collection-name :saas}
   :names      {:type :collection-names}})

(def sample-query {:type :not-found-data
                   :payload (:resources payload)})
