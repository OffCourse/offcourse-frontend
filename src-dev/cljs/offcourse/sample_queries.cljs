(ns offcourse.sample-queries)

(def payload
  {:course   {:type :course
              :course-id "56899a8c-ffb9-42f4-b6f6-7bdc2cf98948/r2j2/1"}
   :courses  {:type :courses
              :course-ids ["56899a8c-ffb9-42f4-b6f6-7bdc2cf98948/r2j2/1"
                           "5689ab1c-a19b-4fa8-be4d-cac87da9c653/charlotte/1"]}
   :curators {:type :collection
              :collection {:collection-type :curators
                           :collection-name :charlotte}}
   :flags    {:type :collection
              :collection {:collection-type :flags
                           :collection-name :new}}
   :tags     {:type :collection
              :collection {:collection-type :tags
                           :collection-name :scalability}}
   :names    {:type :collection-names}})

(def sample-query {:type :not-found-data
                   :payload (:course payload)})
