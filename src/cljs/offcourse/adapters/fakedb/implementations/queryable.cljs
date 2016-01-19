(ns offcourse.adapters.fakedb.implementations.queryable
  (:require  [offcourse.fake-data.index :as fake-data]
             [clojure.set :as set]
             [medley.core :as medley])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch
  (fn [_ {:keys [type]}] type))

(defn create-fake-resource [resource-id]
  (-> fake-data/urls
      rand-nth
      fake-data/create-resource
      (assoc :resource-id resource-id)))

(defonce courses (take 5 (repeatedly fake-data/generate-course)))

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

(defmethod fetch :collection-names [_]
  (go (medley/map-vals #(into #{} (keys %)) collections)))

(defmethod fetch :collection [_ {:keys [collection-name collection-type]}]
  (go {:collection-name collection-name
       :collection-type collection-type
       :course-ids (get-in collections [collection-type collection-name])}))

(defmethod fetch :course [_ {:keys [course-id]}]
  (let [course (some #(if (= (:course-id %) course-id) %) courses)]
    (go (if course course {:error :not-found-data}))))

(defmethod fetch :courses [_ {:keys [course-ids]}]
  (let [courses (map (fn [course-id]
                       (some #(if (= (:course-id %) course-id) %) courses))
                     course-ids)]
    (go (if courses courses {:error :not-found-data}))))

(defmethod fetch :resource [_ {:keys [resource-id]}]
  (go (create-fake-resource resource-id)))

(defmethod fetch :resources [_ {:keys [resource-ids]}]
  (go (map create-fake-resource resource-ids)))
