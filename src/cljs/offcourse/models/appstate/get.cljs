(ns offcourse.models.appstate.get
  (:refer-clojure :exclude [get])
  (:require [com.rpl.specter :refer [ALL select-first]]
            [medley.core :as medley]
            [offcourse.models.appstate.paths :as paths]))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :collection [{:keys [collections] :as ds} {:keys [collection]}]
  (when collections
    (let [{:keys [collection-type collection-name]} collection]
      (select-first (paths/collection collection-type collection-name) ds))))

(defmethod get :courses [{:keys [courses] :as ds} query]
  (when courses
    (let [course-ids (map :course-id (:courses query))]
      (when-let [courses (keep #(select-first (paths/course %) ds) course-ids)]
        (if (empty? courses) nil courses)))))

(defmethod get :course [{:keys [courses] :as ds} {:keys [course]}]
  (when courses
    (let [{:keys [course-id curator goal course-slug]} course]
      (or (select-first (paths/course course-id) ds)
          (select-first (paths/course3 curator course-slug) ds)
          (select-first (paths/course2 curator goal) ds)))))

(defmethod get :checkpoint [{:keys [courses] :as ds} {:keys [checkpoint]}]
  (when courses
    (select-first (paths/checkpoint checkpoint) ds)))

(defmethod get :resources [{:keys [resources] :as ds} query]
  (when resources
    (let [urls (map :url (:resources query))]
      (when-let [resources (keep #(select-first (paths/resource %) ds) urls)]
        (if (empty? resources) nil resources)))))

(defmethod get :resource [{:keys [resources] :as ds} {:keys [resource]}]
  (when resources
    (when-let [{:keys [url]} resource]
      (select-first (paths/resource url) ds))))

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
