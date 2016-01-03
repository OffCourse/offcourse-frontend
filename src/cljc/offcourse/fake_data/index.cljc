(ns offcourse.fake-data.index
  (:require [clojure.string :as str]
            [faker.lorem :as lorem]
            #?(:cljs [cljs-uuid-utils.core :as uuid])
            [offcourse.fake-data.buzzwords :refer [buzzwords]]
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

(defn set-of-buzzwords [min max]
  (->> buzzwords
       shuffle
       (take (rand-int-between min max))
       (map #(str/lower-case %1))
       (into #{})))

(defn course []
  (rand-nth raw-courses))

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
   :completed? completed
   :tags (set-of-buzzwords 0 5)})

(defn- index-checkpoints [checkpoints]
  (->> checkpoints
       (map-indexed #(index-checkpoint %1 %2))))

(defn generate-course []
  (let [base-id (str (uuid/make-random-squuid))
        version 1
        curator (rand-nth users)
        course-id (str base-id "/" curator "/" version)
        ff-id (str base-id "/" (rand-nth users) "/" 0)]
  (-> (course)
      (assoc :base-id base-id)
      (assoc :course-id course-id)
      (assoc :version version)
      (assoc :forked-from ff-id)
      (assoc :forks #{})
      (assoc :curator curator)
      (assoc :flags (generate-flags))
      (update-in [:checkpoints] index-checkpoints))))

#_(def courses
  (->> (take 30 (iterate inc 1))
       (map-indexed (fn [id _] [id (generate-course id)]))
       (into {})))

(def raw-collections
  [[:featured (into #{} (take 10 (iterate inc 1)))]
   [:popular (into #{} (take 5 (iterate inc 2)))]
   [:new (into #{} (take 4 (iterate inc 4)))]])

(def named-collections
  (->> raw-collections
       (map (fn [[collection-name collection-ids]]
              [collection-name {:collection-name collection-name
                                :collection-type :flag-collection
                                :collection-ids collection-ids}]))
       (into {})))

(defn named-collection [collection-name]
  (collection-name named-collections))

(defn create-resource [url]
  (let [{:keys [title text]} (generate-content)]
    {:resource-url url
     :resource-type "markdown"
     :title title
     :authors nil
     :tags (set-of-buzzwords 1 5)
     :content text}))
