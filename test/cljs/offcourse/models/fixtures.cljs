(ns offcourse.models.fixtures
  (:require [offcourse.models.collection :as cl]
            [offcourse.models.course.index :as co]
            [offcourse.models.viewmodel.index :as vm]
            [offcourse.models.profile.index :as pf]
            [cuerdas.core :as str]
            [offcourse.models.checkpoint.index :as cp]))

(def user-name              :yeehaa)
(def id                     (str (name user-name) "::" 123))
(def other-id               (str (name user-name) "::" 129))
(def yet-another-id         (str (name user-name) "::" 445))
(def missing-id             (str (name user-name) "::" 42))
(def other-user-name        :greg)
(def buzzword               :agile)
(def other-buzzword         :netiquette)
(def yet-another-buzzword   :spam)
(def goal                   "alone in the dark")
(def other-goal             "together in the light")
(def slug                   (str/slugify goal))
(def other-slug             (str/slugify other-goal))
(def url                    "http://offcourse.io")
(def other-url              "http://bla.com")
(def yet-another-url        "http://blabla.com")
(def missing-url            "http://facebook.co")
(def flag-type              :featured)
(def collection-type        :flags)
(def other-collection-type  :tags)

(def user               {:name user-name})

(def collection         (cl/new {:collection-type collection-type
                                 :collection-name buzzword
                                 :course-ids      #{}}))

(def flag-collection     (cl/new {:collection-type collection-type
                                  :collection-name flag-type
                                  :course-ids      #{}}))

(def tag-collection      (cl/new {:collection-type other-collection-type
                                  :collection-name buzzword
                                  :course-ids      #{}}))

(def curator-collection  (cl/new {:collection-type :curators
                                  :collection-name user-name
                                  :course-ids      #{}}))

(def checkpoint          (cp/new {:checkpoint-id   1
                                  :task            goal
                                  :checkpoint-slug slug
                                  :url             url
                                  :tags            #{buzzword}}))

(def profile             (pf/new {:user-name user-name}))

(def course              (co/new {:course-id   id
                                  :base-id     id
                                  :revision    0
                                  :forks       #{}
                                  :timestamp   (.now js/Date)
                                  :goal        goal
                                  :course-slug slug
                                  :flags       #{flag-type}
                                  :checkpoints [checkpoint]
                                  :curator     user-name}))

(def resource            {:url url})

(def loading-vm          (vm/new {:type :loading-view}))

(def checkpoint-vm       (vm/new {:type   :checkpoint-view
                                  :course course
                                  :checkpoint {:checkpoint-slug slug}}))

(def new-course-vm       (vm/new {:type :new-course-view
                                  :user-name user-name
                                  :course course}))

(def collection-vm       (vm/new {:type       :collection-view
                                  :collection collection}))

