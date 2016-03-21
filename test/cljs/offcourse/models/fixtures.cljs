(ns offcourse.models.fixtures
  (:require [offcourse.models.collection :as cl]
            [offcourse.models.course.index :as co]
            [cuerdas.core :as str]))

(def id                     123)
(def other-id               129)
(def yet-another-id         443)
(def missing-id             223)
(def user-name              :yeehaa)
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
(def collection-type        :flags)
(def other-collection-type  :tags)

(def collection      (cl/new {:collection-type collection-type
                              :collection-name buzzword
                              :course-ids      #{}}))

(def checkpoint      {:checkpoint-id   1
                      :checkpoint-slug slug
                      :url             url
                      :tags            #{buzzword}
                      :resource-id     id})

(def course          (co/new {:course-id   id
                              :goal        goal
                              :course-slug slug
                              :flags       #{collection-type}
                              :checkpoints [checkpoint]
                              :curator     user-name
                              :hashtag     buzzword}))

(def resource         {:url url})

(def course-data {:course-id id})

(def loading-vm {:viewmodel {:type :loading-view}})

(def checkpoint-vm {:type         :checkpoint-view
                    :dependencies {:course course}})

(def course-vm {:type         :course-view
                :dependencies {:course course}})

(def collection-vm {:type         :collection-view
                    :dependencies {:collection collection}})
