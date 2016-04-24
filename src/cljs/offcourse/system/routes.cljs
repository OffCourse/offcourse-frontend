(ns offcourse.system.routes
  (:require [offcourse.models.collection :as cl]
            [bidi.bidi :refer [path-for]]
            [offcourse.views.helpers :as vh]))

(def home-route        [[keyword :collection-name]])
(def curator-routes    [[keyword :curator]])
(def new-user-route    "signup")
(def new-course-routes (conj curator-routes "/new"))
(def course-routes     (conj curator-routes "/courses/" :course-slug))
(def collection-routes [[keyword :collection-type] "/" [keyword :collection-name]])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-slug))

(def table ["/" {home-route        :home-view
                 checkpoint-routes :checkpoint-view
                 new-user-route    :new-user-view
                 new-course-routes :new-course-view
                 course-routes     :course-view
                 collection-routes :collection-view
                 true              :home-view}])

(def responses
  {:home-view       (fn [] (vh/collection-view (cl/new :flags :featured)))
   :new-course-view (fn [data] (vh/new-course-view data))
   :collection-view (fn [data] (vh/collection-view data))
   :course-view (fn [data] (vh/course-view data))
   :checkpoint-view (fn [data] (vh/checkpoint-view data))})

(def url-helpers
  (let [create-url     (partial path-for table)
        collection-url (fn [collection-type collection-name]
                         (create-url :collection-view
                                     :collection-type collection-type
                                     :collection-name collection-name))
        course-url     (fn [curator course-slug] (create-url :course-view
                                                             :curator curator
                                                             :course-slug course-slug))
        new-course-url (fn [curator] (create-url :new-course-view
                                                 :curator curator))
        checkpoint-url (fn [curator course-slug checkpoint-slug checkpoint-id]
                         (create-url :checkpoint-view
                                     :curator curator
                                     :course-slug course-slug
                                     :checkpoint-slug checkpoint-slug))
        profile-url    (fn [curator] (collection-url :curators curator))
        home-url       (collection-url :flags :featured)]
    {:home-url       home-url
     :profile-url    profile-url
     :new-course-url new-course-url
     :course-url     course-url
     :collection-url collection-url
     :checkpoint-url checkpoint-url}))
