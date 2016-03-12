(ns offcourse.models.appstate.missing-data
  (:require [offcourse.protocols.queryable :as qa]))

(defmulti missing-data
  (fn [{:keys [viewmodel]}] (:type viewmodel)))

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

(defmethod missing-data :course-view [{:keys [resources] :as as} data-type]
  (when (< (count resources) 5) {:type :resources
                                  :tags [:featured]}))

(defmethod missing-data :default [{:keys [viewmodel]}]
  (when-not (= (:type viewmodel) :loading-view)
    {:type :error
     :error :appstate-empty}))
