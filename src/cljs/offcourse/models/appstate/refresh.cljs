(ns offcourse.models.appstate.refresh
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select-first transform]]
            [offcourse.models.appstate.paths :as paths]))

(defn deep-merge
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (last vs)))

(defn add-course [store course]
  (update-in store [:courses] #(conj % course)))

(defn add-resource [store resource]
  (let [store-urls (into #{} (map :url (:resources store)))]
    (if-not (contains? store-urls (:url resource))
      (update-in store [:resources] #(conj % resource))
      store)))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :view [state {:keys [view-data]}]
  (-> (merge state view-data)
      (assoc :viewmodel view-data)))

(defmethod refresh :user [state {:keys [user]}]
  (assoc state :user user))

(defmethod refresh :collection [store {:keys [collection] :as query}]
  (when-let [{:keys [collection-type collection-name course-ids]} collection]
    (let [collection-path (paths/collection collection-type collection-name)
          courses-path    [collection-path :course-ids]]
      (if-let [store-ids (select-first courses-path store)]
        (transform courses-path #(set/union store-ids course-ids) store)
        (transform [:collections] #(conj % collection) store)))))

(defmethod refresh :courses [store query]
  (let [store-ids (into #{} (map :course-id (:courses store)))
        query-ids (into #{} (map :course-id (:courses query)))
        missing-ids (set/difference query-ids store-ids)
        missing-courses (keep (fn [{:keys [course-id] :as course}]
                                (when (contains? missing-ids course-id) course))
                              (:courses query))]
    (if-not (empty? missing-ids)
      (reduce add-course store missing-courses)
      store)))

(defmethod refresh :course [store {:keys [course]}]
  (let [store-ids (into #{} (map :course-id (:courses store)))]
    (if-not (contains? store-ids (:course-id course))
      (add-course store course)
      store)))

(defmethod refresh :resources [store {:keys [resources]}]
  (reduce add-resource store resources))

(defmethod refresh :resource [store {:keys [resource]}]
  (add-resource store resource))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
