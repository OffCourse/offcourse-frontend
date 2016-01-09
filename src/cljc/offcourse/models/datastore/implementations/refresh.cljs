(ns offcourse.models.datastore.implementations.refresh
  (:require [offcourse.models.collection :as cl]
            [medley.core :as medley]))

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

(defmethod refresh :collection-names [store {:keys [collection-names] :as query}]
  (let [collections (map-collections collection-names)]
    (assoc store :collections collections
                 :has-collection-names? true)))

(defmethod refresh :collection [store {:keys [collection]}]
  (let [{:keys [collection-name collection-type course-ids]} collection]
    (assoc-in store [:collections collection-type collection-name] collection)))

(defmethod refresh :courses [store {:keys [courses]}]
  (reduce add-course store courses))

(defmethod refresh :course [store {:keys [course]}]
  (add-course store course))

(defmethod refresh :resources [store {:keys [resources]}]
  (reduce add-resource store resources))

(defmethod refresh :resource [store {:keys [resource]}]
  (add-resource store resource))
