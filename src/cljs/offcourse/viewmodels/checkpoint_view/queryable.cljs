(ns offcourse.viewmodels.checkpoint-view.queryable
  (:require [offcourse.models.course :as co]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [offcourse.models.label :as lb]))

(defn course-by-id [{:keys [course-id]}]
  [ALL #(= (:course-id %) course-id)])

(defn course-by-curator-and-hashtag [{:keys [curator hashtag]}]
  [ALL #(and (= (:hashtag %) hashtag)
             (= (:curator %) curator))])

(defn refresh [{:keys [course checkpoint-id] :as vm} {:keys [courses resources] :as store}]
  (let [course       (if courses (or (select-first (course-by-id course) courses)
                                     (select-first (course-by-curator-and-hashtag course) courses))
                         course)
        resource-id (->> (:checkpoints course)
                         (some #(if (= (:checkpoint-id %) checkpoint-id) %))
                         :resource-id)
        tags         (co/get-tags course)]
    (merge vm {:course    course
               :labels    {:tags (lb/collection->labels tags)}
               :resource (get resources resource-id)})))
