(ns offcourse.models.datastore.implementations.refresh
  (:require [offcourse.models.collection :as cl]
            [medley.core :as medley]
            [clojure.set :as set]))

(defn deep-merge
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (last vs)))

(defn initialize-collection [collection-type collection-name]
  [collection-name (cl/new-collection collection-type collection-name)])

(defn initialize-collections [collection-type collection-names]
  [collection-type (->> collection-names
                        (map #(initialize-collection collection-type %))
                        (into {}))])

(defn add-course [store {:keys [course-id] :as course}]
  (assoc-in store [:courses course-id] course))

(defn add-resource [store {:keys [resource-id] :as resource}]
  (assoc-in store [:resources resource-id] resource))

(defn map-collections [collection-names]
  (medley/map-kv initialize-collections collection-names))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :collection-names [{:keys [collections] :as store}
                                      {:keys [collection-names] :as query}]
  (let [collections (-> collection-names
                        map-collections
                        (deep-merge (or collections {})))]
    (assoc store :collections collections
           :has-collection-names? true)))

(defmethod refresh :collection [store {:keys [collection]}]
  (let [{:keys [collection-type collection-name course-ids]} collection]
    (if-let [store-ids (get-in store [:collections collection-type collection-name :course-ids])]
      (update-in store [:collections collection-type collection-name :course-ids]
                 #(set/union store-ids course-ids))
      (assoc-in store [:collections collection-type collection-name] collection))))

(defmethod refresh :courses [store {:keys [courses]}]
  (reduce add-course store courses))

(defmethod refresh :course [store {:keys [course]}]
  (add-course store course))

(defmethod refresh :resources [store {:keys [resources]}]
  (reduce add-resource store resources))

(defmethod refresh :resource [store {:keys [resource]}]
  (add-resource store resource))
