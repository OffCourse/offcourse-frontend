(ns offcourse.sample-queries)

(def payload
  {:course   {:type :course
              :course-id "68c1e33-bfaa-4f99-aef9-8774e0f77aee/yeehaa/1"}
   :courses  {:type :courses
              :course-ids ["568c1e33-bfaa-4f99-aef9-8774e0f77aee/yeehaa/1"
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
                   :payload (:courses payload)})
