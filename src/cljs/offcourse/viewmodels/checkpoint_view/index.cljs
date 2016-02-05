(ns offcourse.viewmodels.checkpoint-view.index
  (:require [offcourse.viewmodels.checkpoint-view.queryable :as qa-impl]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
            [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [offcourse.models.label :as lb :refer [Label]]))

(defn course-by-id [courses id]
  (select-first [ALL #(= (:course-id %) id)] courses))

(defn course-by-curator-and-hashtag [courses curator hashtag]
  (select-first [ALL #(and (= (:hashtag %) hashtag)
                           (= (:curator %) curator))] courses))

(defn dummy-course [course-id curator hashtag]
  (if course-id {:course-id course-id}
      {:curator curator
       :hashtag hashtag}))

(schema/defrecord CheckpointView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     checkpoint-id :- schema/Num
     resource :- Resource]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CheckpointView vm))
  (refresh [vm store] #_(qa-impl/refresh vm store)))

(defn new
  ([{:keys [type course-id checkpoint-id curator hashtag] :as view-data}]
   (let [course (if course-id {:course-id course-id}
                    {:curator curator
                     :hashtag hashtag})]
     (map->CheckpointView {:view-name type
                           :checkpoint-id (js/parseInt checkpoint-id)
                           :course course})))
  ([{:keys [type course-id curator hashtag checkpoint-id] :as view-data}
    {:keys [courses resources] :as store}]
   (let [course      (if courses (or (course-by-id courses course-id)
                                     (course-by-curator-and-hashtag courses curator hashtag))
                         (dummy-course course-id curator hashtag))
         tags        (co/get-tags course)
         resource-id (->> (:checkpoints course)
                          (some #(if (= (:checkpoint-id %) checkpoint-id) %))
                          :resource-id)]
     (map->CheckpointView {:view-name type
                           :course   course
                           :labels   {:tags (lb/collection->labels tags)}
                           :resource (get resources resource-id)}))))
