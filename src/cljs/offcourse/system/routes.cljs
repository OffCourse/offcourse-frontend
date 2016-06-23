(ns offcourse.system.routes
  (:require [bidi.bidi :refer [path-for]]
            [offcourse.models.payload :as payload]
            [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint.index :as cp]))

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
  {:home-view       (fn []     (payload/new :home-view))
   :new-course-view (fn [data] (payload/new :new-course-view
                                            {:new-course (co/new {:curator (:curator data)})
                                             :new-checkpoint (cp/new {})}))
   :collection-view (fn [data] (payload/new :collection-view data))
   :course-view     (fn [data] (payload/new :course-view data))
   :checkpoint-view (fn [data] (payload/new :checkpoint-view data))})

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
