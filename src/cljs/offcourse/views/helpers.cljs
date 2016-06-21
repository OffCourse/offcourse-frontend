(ns offcourse.views.helpers
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.profile.index :as pf]
            [offcourse.models.checkpoint.index :as cp]))

(defn home-view []
  {:type    :collection
   :collection {:collection-type :flags
                :collection-name :featured}})

(defn collection-view [collection]
  {:type    :collection
   :collection collection})

(defn checkpoint-view [data]
  {:type :checkpoint
   :course     (select-keys data [:curator :course-slug])
   :checkpoint (select-keys data [:checkpoint-slug :checkpoint-id])})

(defn course-view [data]
  {:type :course
   :course     (select-keys data [:curator :course-slug])})

(defn new-course-view [{:keys [curator]}]
  {:type :new-course
   :new-course     (co/new {:curator curator})
   :new-checkpoint (cp/new {})})

(defn signup-view []
  {:type :signup
   :new-user (pf/new {})})
