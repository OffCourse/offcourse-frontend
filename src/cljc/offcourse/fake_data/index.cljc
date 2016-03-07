(ns offcourse.fake-data.index
  (:require [clojure.string :as str]
            [faker.lorem :as lorem]
            #?(:cljs [cljs-uuid-utils.core :as uuid])
            [offcourse.fake-data.buzzwords :as bw]
            [offcourse.fake-data.courses :refer [raw-courses]]))

(def checkpoint {:checkpoint-id :new
                 :task "Do Something Different"
                 :url "bla.com"
                 :completed false})

(def urls ["facebook.com"
           "google.com"
           "yahoo.com"
           "offcourse.io"])

(def users ["yeehaa" "greg" "r2j2" "reika" "charlotte" "marijn"])

(defn rand-int-between [min max]
  (let [dev (- max min)]
    (+ (rand-int dev) min)))

(defn make-description []
  (->> (lorem/words)
       (take (rand-int-between 10 40))
       (map #(str/capitalize %1))
       (str/join " ")))

(defn make-title []
  (->> (lorem/words)
       (take (rand-int-between 3 8))
       (map #(str/capitalize %1))
       (str/join " ")))

(def body
  (->> (lorem/paragraphs (rand-int-between 8 15))
       (take (rand-int-between 10 40))))

(defn make-text [title]
  (->> (conj body (str "# " title))
       (str/join "\n\n")))

(defn generate-content []
  (let [title (make-title)
        text (make-text title)]
    {:title title
     :text text}))


(defn to-snake-case [str]
  (as-> str %
    (str/lower-case %)
    (str/split % #" ")
    (str/join "-" %)))

(def buzzwords (map to-snake-case bw/buzzwords))
(def hashtags (atom (shuffle buzzwords)))

(defn set-of-buzzwords [min max]
  (->> buzzwords
       shuffle
       (take (rand-int-between min max))
       (into #{})))

(def flags [:featured :new :popular])

(defn generate-flags []
  (->> flags
       shuffle
       (take (rand-int 4))
       (into #{})))

(defn generate-user []
  (rand-nth users))

(defn- index-checkpoint [index {:keys [task completed]}]
  {:checkpoint-id index
   :order index
   :task task
   :resource-id (str (uuid/make-random-squuid))
   :tags (set-of-buzzwords 0 5)})

(defn- index-checkpoints [checkpoints]
  (->> checkpoints
       (map-indexed #(index-checkpoint %1 %2))))

(defn add-ids [course]
  (let [base-id (hash course)]
    (merge course {:base-id base-id
                   :course-id base-id})))

(defn hashtag []
  (let [hashtag (peek @hashtags)]
    (swap! hashtags pop)
    hashtag))

(defn generate-course
  ([] (generate-course (rand-nth users) (hashtag)))
  ([curator hashtag] (-> raw-courses
                         rand-nth
                         (assoc :version [0 0 0]
                                :revision 0
                                :hashtag hashtag
                                :description (make-description)
                                :timestamp (.now js/Date)
                                :forked-from nil
                                :forks #{}
                                :curator curator
                                :flags (generate-flags))
                         (update-in [:checkpoints] index-checkpoints)
                         add-ids)))

(defn create-resource [url]
  (let [{:keys [title text]} (generate-content)]
    {:url     url
     :type    :markdown
     :title   title
     :authors nil
     :tags    (set-of-buzzwords 1 5)
     :content text}))
