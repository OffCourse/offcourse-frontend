(ns offcourse.models.datastore.fixtures)

(def course-id 123)
(def resource-id 123)
(def resource {:resource-id resource-id})
(def curator :yeehaa)
(def hashtag :netiquette)
(def collection-type :flags)
(def collection-name :taurus)
(def collection {:collection-type collection-type
                 :collection-name collection-name
                 :course-ids #{course-id}})

(def empty-collection {:collection-type collection-type
                       :collection-name hashtag
                       :course-ids #{}})

(def store {:has-collection-names? false
            :collections {collection-type {collection-name collection
                                           hashtag empty-collection}}
            :courses [{:course-id course-id
                       :curator curator
                       :hashtag hashtag}
                      {:course-id 589
                       :curator :marijn
                       :hashtag :agile}]
            :resources {resource-id resource}})

