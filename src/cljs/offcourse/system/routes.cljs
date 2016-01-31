(ns offcourse.system.routes)

(def home-route        [[keyword :collection-name]])
(def course-routes     ["courses/" [keyword :curator] "/" [keyword :hashtag]])
(def collection-routes [[keyword :collection-type] "/" [keyword :collection-name]])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-id))

(def routes ["/" {home-route        :home-view
                  course-routes     :course-view
                  collection-routes :collection-view
                  checkpoint-routes :checkpoint-view
                  true              :home-view}])
