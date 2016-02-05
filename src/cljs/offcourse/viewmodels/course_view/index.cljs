(ns offcourse.viewmodels.course-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.viewmodels.course-view.queryable :as qa-impl]
            [offcourse.viewmodels.course-view.validatable :as va-impl]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [schema.core :as schema :include-macros true]
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

(schema/defrecord CourseView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     resources :- (schema/conditional #(not (nil? %)) [Resource])]
  Validatable
  (missing-data [vm] (va-impl/missing-data vm))
  (valid? [vm] (if (qa/check vm) false true))
  Queryable
  (check [vm] (schema/check CourseView vm))
  (refresh [vm store] #_(qa-impl/refresh vm store)))

(defn new
  ([{:keys [type course-id curator hashtag] :as view-data}]
     (map->CourseView {:view-name type
                       :course    (dummy-course course-id curator hashtag)}))
  ([{:keys [type course-id curator hashtag] :as view-data}
    {:keys [courses resources] :as store}]
   (let [course       (if courses (or (course-by-id courses course-id)
                                      (course-by-curator-and-hashtag courses curator hashtag))
                          (dummy-course course-id curator hashtag))
         tags         (co/get-tags course)
         resource-ids (co/get-resource-ids course)]
     (map->CourseView {:view-name type
                       :course    course
                       :labels    {:tags (lb/collection->labels tags)}
                       :resources (map #(get resources %) resource-ids)}))))
