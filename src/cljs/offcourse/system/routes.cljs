(ns offcourse.system.routes)

(def home-route        [[keyword :collection-name]])
(def curator-routes    ["courses/" [keyword :curator]])
(def new-course-routes (conj curator-routes "/new"))
(def course-routes     (conj curator-routes "/" [keyword :hashtag]))
(def collection-routes [[keyword :collection-type] "/" [keyword :collection-name]])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-id))

(def routes ["/" {home-route        :home-view
                  checkpoint-routes :checkpoint-view
                  new-course-routes :new-course-view
                  course-routes     :checkpoint-view
                  collection-routes :collection-view
                  true              :home-view}])


