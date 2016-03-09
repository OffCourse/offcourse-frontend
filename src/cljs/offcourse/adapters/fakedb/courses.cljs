(ns offcourse.adapters.fakedb.courses
  (:require [offcourse.adapters.fakedb.helpers :as h]
            [com.rpl.specter :refer [ALL select select-first]]
            [offcourse.fake-data.courses :refer [raw-courses]]))

(defn- index-checkpoint [index {:keys [task completed]} urls]
  {:checkpoint-id index
   :order index
   :task task
   :url (rand-nth urls)
   :tags (h/set-of-buzzwords 0 5)})

(defn- index-checkpoints [checkpoints urls]
  (->> checkpoints
       (map-indexed #(index-checkpoint %1 %2 urls))))

(defn add-ids [course]
  (let [base-id (hash course)]
    (merge course {:base-id base-id
                   :course-id base-id})))

(defn hashtag []
  (let [hashtag (peek @h/hashtags)]
    (swap! h/hashtags pop)
    hashtag))

(defn generate-course
  ([] (generate-course (rand-nth h/users) (hashtag)))
  ([curator hashtag] (-> raw-courses
                         rand-nth
                         (assoc :version [0 0 0]
                                :revision 0
                                :hashtag hashtag
                                :timestamp (.now js/Date)
                                :forked-from nil
                                :forks #{}
                                :curator curator
                                :flags (h/generate-flags))
                         (update-in [:checkpoints] #(index-checkpoints % h/urls))
                         add-ids)))

(defn courses-by-id [course-ids courses]
  (select [ALL #(contains? course-ids (:course-id %))] courses))

(defn course-by-id [{:keys [course-id]} courses]
  (select-first [ALL #(= (:course-id %) course-id)] courses))

(defn course-by-curator-and-hashtag [{:keys [curator hashtag]} courses]
  (select-first [ALL #(and (= (:hashtag %) (name hashtag))
                           (= (:curator %) (name curator)))] courses))

(defn courses []
  (conj (take 10 (repeatedly generate-course))
        (generate-course "yeehaa" "netiquette")))
