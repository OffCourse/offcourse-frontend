(ns offcourse.adapters.fakedb.courses
  (:require [offcourse.adapters.fakedb.helpers :as h]
            [com.rpl.specter :refer [ALL select select-first]]
            [cuerdas.core :as str]
            [offcourse.fake-data.courses :refer [raw-courses]]))

(defn- index-checkpoint [index {:keys [task completed]} urls]
  {:checkpoint-id index
   :task task
   :url (rand-nth urls)
   :tags (h/set-of-buzzwords 0 5)})

(defn- index-checkpoints [checkpoints urls]
  (->> checkpoints
       (map-indexed #(index-checkpoint %1 %2 urls))))

(defn add-ids [{:keys [goal curator] :as course}]
  (let [base-id (hash course)]
    (merge course {:base-id base-id
                   :course-id base-id})))

(defn add-slug [{:keys [goal] :as course}]
  (assoc course :slug (str/slugify goal)))

(defn generate-course
  ([] (generate-course (rand-nth h/users)))
  ([curator] (-> raw-courses
                         rand-nth
                         (assoc :version [0 0 0]
                                :revision 0
                                :timestamp (.now js/Date)
                                :forked-from nil
                                :forks #{}
                                :curator curator
                                :flags (h/generate-flags))
                         (update :checkpoints #(index-checkpoints % h/urls))
                         add-slug
                         add-ids)))

(defn courses-by-id [course-ids courses]
  (select [ALL #(contains? course-ids (:course-id %))] courses))

(defn course-by-id [{:keys [course-id]} courses]
  (select-first [ALL #(= (:course-id %) course-id)] courses))

(defn course-by-curator-and-slug [{:keys [curator slug]} courses]
  (select-first [ALL #(and (= (:slug %) slug)
                           (= (:curator %) (name curator)))] courses))

(defn courses []
  (conj (take 10 (repeatedly generate-course))
        (generate-course "yeehaa")))
