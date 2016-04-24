(ns offcourse.models.appstate.missing-data
  (:require [offcourse.protocols.queryable :as qa]
            [clojure.set :as set]
            [com.rpl.specter :refer [ALL transform select-first]]
            [offcourse.models.appstate.paths :as paths]))

(defmulti missing-data
  (fn [{:keys [viewmodel]} {:keys [type] :as query}]
    (or type (:type viewmodel))))

(defmethod missing-data :collection-view [{:keys [viewmodel collection] :as as}]
  (let [{:keys [dependencies]} viewmodel]
    (if-let [data-present? (qa/check as :collection (:collection dependencies))]
      (let [collection (qa/get as :collection (:collection dependencies))
            course-ids (:course-ids collection)
            query {:type :courses
                   :course-ids course-ids}]
        (when-not (qa/check as query) query))
      {:type :collection
       :collection (:collection dependencies)})))

(defmethod missing-data :course-view [{:keys [viewmodel] :as as}]
  (let [{:keys [dependencies]} viewmodel]
    (when-not (qa/check as :course (:course dependencies))
      {:type :course
       :course (:course dependencies)})))

(defmethod missing-data :checkpoint-view [{:keys [viewmodel] :as as}]
  (let [{:keys [dependencies]} viewmodel]
    (if-let [data-present? (qa/check as :course (:course dependencies))]
      (let [course (qa/get as :course (:course dependencies))
            urls   (qa/get course :urls {})
            query  {:type :resources
                    :urls urls}]
        (when-not (or (qa/check as query) (empty? urls)) query))
      {:type :course
       :course (:course dependencies)})))

(defmethod missing-data :new-user-view [as data-type]
  false)

(defmethod missing-data :new-course-view [{:keys [resources] :as as} data-type]
  (when (< (count resources) 5) {:type :resources
                                 :tags [:featured]}))

(defmethod missing-data :courses [store {:keys [courses] :as query}]
  (let [store-ids (into #{} (map :course-id (:courses store)))
        query-ids (into #{} (map :course-id (:courses query)))
        missing-ids (set/difference query-ids store-ids)
        missing-courses (keep (fn [{:keys [course-id] :as course}]
                                (when (contains? missing-ids course-id) course))
                              (:courses query))]
    (when-not (empty? missing-ids)
      {:type :courses
       :courses missing-courses})))

(defmethod missing-data :course [store {:keys [course] :as query}]
  (let [store-ids (into #{} (map :course-id (:courses store)))]
    (when-not (contains? store-ids (:course-id course))
      {:type :course
       :course (select-keys course [:course-id])})))

(defmethod missing-data :resources [store {:keys [resources] :as query}]
  (let [store-urls        (into #{} (map :url (:resources store)))
        query-urls        (into #{} (map :url (:resources query)))
        missing-urls      (set/difference query-urls store-urls)
        missing-resources (map #(select-first (paths/resource %) query) missing-urls)]
    (when-not (empty? missing-urls)
      {:type      :resources
       :resources missing-resources})))

(defmethod missing-data :resource [store {:keys [resource] :as query}]
  (let [store-urls (into #{} (map :url (:resources store)))]
    (when-not (contains? store-urls (:url resource))
      {:type :resource
       :resource (select-keys resource [:url])})))

(defmethod missing-data :default [{:keys [viewmodel]}]
  (when-not (= (:type viewmodel) :loading-view)
    {:type :error
     :error :appstate-empty}))
