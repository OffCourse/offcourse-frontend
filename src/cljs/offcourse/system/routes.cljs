(ns offcourse.system.routes)

(def home-route        [[keyword :collection-name]])
(def course-routes     ["courses/" [keyword :curator] "/" [keyword :hashtag]])
(def collection-routes [[keyword :collection-type] "/" [keyword :collection-name]])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-id))

(def routes ["/" {home-route        :home-view
                  checkpoint-routes :checkpoint-view
                  course-routes     :checkpoint-view
                  collection-routes :collection-view
                  true              :home-view}])


