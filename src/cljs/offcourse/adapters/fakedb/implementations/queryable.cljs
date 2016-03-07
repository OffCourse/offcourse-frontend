(ns offcourse.adapters.fakedb.implementations.queryable
  (:require  [offcourse.fake-data.index :as fake-data]
             [clojure.set :as set]
             [medley.core :as medley]
             [cljs.pprint :as pprint]
             [com.rpl.specter :refer [select select-first filterer ALL]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn create-fake-resource [resource-id]
  (-> fake-data/urls
      rand-nth
      fake-data/create-resource
      (assoc :resource-id resource-id)))

(defonce courses (conj (take 10 (repeatedly fake-data/generate-course))
                       (fake-data/generate-course "yeehaa" "netiquette")))

(defonce tag-collections
  (->> courses
       (map #(assoc % :tags (apply set/union (map :tags (:checkpoints %)))))
       (reduce (fn [acc {:keys [course-id tags]}]
          (reduce (fn [acc tag]
                    (update-in acc [(keyword tag)] #(into #{} (conj % course-id))))
                  acc tags))
        {})))

(defonce flag-collections
  (->> courses
       (reduce
        (fn [acc {:keys [course-id flags]}]
          (reduce (fn [acc flag]
                    (update-in acc [(keyword flag)] #(into #{} (conj % course-id))))
                  acc flags))
        {})))

(defonce curator-collections
  (->> courses
       (reduce (fn [acc {:keys [course-id curator]}]
                 (update-in acc [(keyword curator)]
                            #(into #{} (conj % course-id))))
               {})))

(defonce collections
  {:tags tag-collections
   :flags flag-collections
   :curators curator-collections})

(defmulti fetch
  (fn [_ {:keys [type]}] type))

(defmethod fetch :collection-names [_]
  (go (medley/map-vals #(into #{} (keys %)) collections)))

(defmethod fetch :collection [_ {:keys [collection]}]
  (when-let [{:keys [collection-name collection-type]} collection]
    (go {:collection-name collection-name
         :collection-type collection-type
         :course-ids (get-in collections [collection-type collection-name])})))

(defn course-by-id [{:keys [course-id]}]
  [ALL #(= (:course-id %) course-id)])

(defn course-by-curator-and-hashtag [{:keys [curator hashtag]}]
  [ALL #(and (= (:hashtag %) (name hashtag))
             (= (:curator %) (name curator)))])

(defmethod fetch :course [_ {:keys [course]}]
  (let [{:keys [course-id curator hashtag]} course
        course (or (select-first (course-by-id course) courses)
                   (select-first (course-by-curator-and-hashtag course) courses))]
    (go (if course course {:error :not-found-data}))))

(defmethod fetch :courses [_ {:keys [course-ids]}]
  (let [courses (select [ALL #(contains? course-ids (:course-id %))] courses)]
    (go (if courses courses {:error :not-found-data}))))

(defmethod fetch :resource [_ {:keys [resource-id]}]
  (go (create-fake-resource resource-id)))

(defmethod fetch :resources [_ {:keys [resource-ids]}]
  (go
    (if (= resource-ids :featured)
      (map create-fake-resource ["aa" "bb" "cc" "dd" "ee" "ff"])
      (map create-fake-resource resource-ids))))
