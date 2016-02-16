(ns offcourse.system.routes
  (:require [bidi.bidi :refer [path-for]]))

(def home-route        [[keyword :collection-name]])
(def course-routes     ["courses/" [keyword :curator] "/" [keyword :hashtag]])
(def collection-routes [[keyword :collection-type] "/" [keyword :collection-name]])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-id))

(def routes ["/" {home-route        :home-view
                  checkpoint-routes :checkpoint-view
                  course-routes     :checkpoint-view
                  collection-routes :collection-view
                  true              :home-view}])


(defn route-helpers [routes]
  (let [create-url     (partial path-for routes)
        collection-url (fn [collection-type collection-name]
                         (create-url :collection-view
                                     :collection-type collection-type
                                     :collection-name collection-name))
        checkpoint-url (fn [curator hashtag checkpoint-id]
                         (create-url :checkpoint-view
                                     :curator curator
                                     :hashtag hashtag
                                     :checkpoint-id checkpoint-id))
        home-url       (collection-url :flags :featured)]
    {:create-url     create-url
     :home-url       home-url
     :collection-url collection-url
     :checkpoint-url checkpoint-url}))
