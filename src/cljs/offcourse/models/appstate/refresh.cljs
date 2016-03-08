(ns offcourse.models.appstate.refresh
  (:require [offcourse.models.collection :as cl]
            [medley.core :as medley]
            [com.rpl.specter :refer [select select-first transform filterer ALL]]
            [clojure.set :as set]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]))

(defn deep-merge
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (last vs)))

(defn add-course [store course]
  (update-in store [:courses] #(conj % course)))

(defn add-resource [store resource]
  (update-in store [:resources] #(conj % resource)))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :appstate [state {:keys [appstate]}]
  (merge state appstate))

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

(defmethod refresh :resources [store query]
  (let [store-urls        (into #{} (map :url (:resources store)))
        query-urls        (into #{} (map :url (:resources query)))
        missing-urls      (set/difference query-urls store-urls)
        missing-resources (keep (fn [{:keys [url] :as resource}]
                                  (when (contains? missing-urls url) resource))
                                (:resources query))]
    (if-not (empty? missing-urls)
      (reduce add-resource store missing-resources)
      store)))

(defmethod refresh :resource [store {:keys [resource]}]
  (let [store-urls (into #{} (map :url (:resources store)))]
    (if-not (contains? store-urls (:url resource))
      (add-resource store resource)
      store)))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
