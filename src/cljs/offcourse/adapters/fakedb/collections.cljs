(ns offcourse.adapters.fakedb.collections
  (:require [clojure.set :as set]))

(defn tag-collections [courses]
  (->> courses
       (map #(assoc % :tags (apply set/union (map :tags (:checkpoints %)))))
       (reduce (fn [acc {:keys [course-id tags]}]
                 (reduce (fn [acc tag]
                           (update-in acc [(keyword tag)] #(into #{} (conj % course-id))))
                         acc tags))
               {})))

(defn flag-collections [courses]
  (->> courses
       (reduce
        (fn [acc {:keys [course-id flags]}]
          (reduce (fn [acc flag]
                    (update-in acc [(keyword flag)] #(into #{} (conj % course-id))))
                  acc flags))
        {})))

(defn curator-collections [courses]
  (->> courses
       (reduce (fn [acc {:keys [course-id curator]}]
                 (update-in acc [(keyword curator)]
                            #(into #{} (conj % course-id))))
               {})))

(defn collections [courses]
  {:tags (tag-collections courses)
   :flags (flag-collections courses)
   :curators (curator-collections courses)})
