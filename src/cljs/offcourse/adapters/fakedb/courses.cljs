(ns offcourse.adapters.fakedb.courses
  (:require [offcourse.adapters.fakedb.helpers :as h]
            [com.rpl.specter :refer [ALL select select-first]]
            [cuerdas.core :as str]
            [offcourse.fake-data.courses :refer [raw-courses]]))

(defn completed-val []
  (rand-nth [((fn [] false)) ((fn [] (.now js/Date)))]))

(defn- index-checkpoint [index {:keys [task completed]} urls]
  {:checkpoint-id index
   :checkpoint-slug (str/slugify task)
   :completed? nil
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
  (assoc course :course-slug (str/slugify goal)))

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

(defn course-by-curator-and-slug [{:keys [curator course-slug]} courses]
  (select-first [ALL #(and (= (:course-slug %) course-slug)
                           (= (:curator %) (name curator)))] courses))

(defn courses []
  (conj (take 15 (repeatedly generate-course))
        (generate-course "yeehaa")))
