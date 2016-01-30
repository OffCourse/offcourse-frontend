(ns offcourse.viewmodels.course-view.queryable
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [cljs.pprint :as pprint]))

(defn course-by-id [{:keys [course-id]}]
  [ALL #(= (:course-id %) course-id)])

(defn course-by-curator-and-hashtag [{:keys [curator hashtag]}]
  [ALL #(and (= (:hashtag %) hashtag)
             (= (:curator %) curator))])

(defn refresh [{:keys [course] :as vm} {:keys [courses resources] :as store}]
  (let [course       (if courses (or (select-first (course-by-id course) courses)
                                     (select-first (course-by-curator-and-hashtag course) courses))
                         course)
        tags         (co/get-tags course)
        resource-ids (co/get-resource-ids course)]
    (merge vm {:course    course
               :labels    {:tags (lb/collection->labels tags)}
               :resources (map #(get resources %) resource-ids)})))

