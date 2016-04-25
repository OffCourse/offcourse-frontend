(ns offcourse.adapters.fakedb.implementations.queryable
  (:require [com.rpl.specter :refer [ALL select select-first]]
            [offcourse.adapters.fakedb.collections :as cl]
            [offcourse.adapters.fakedb.courses :as cs]
            [offcourse.adapters.fakedb.resources :as r])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defonce courses   (cs/courses))
(defonce all-resources (r/resources courses))
(defonce collections (cl/collections courses))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :collection [_ {:keys [collection]}]
  (when-let [{:keys [collection-name collection-type]} collection]
    (go {:collection-name collection-name
         :collection-type collection-type
         :course-ids (get-in collections [collection-type collection-name])})))

(defmethod fetch :course [_ {:keys [course]}]
  (go
    (if-let [course (or (cs/course-by-id course courses)
                        (cs/course-by-curator-and-slug course courses))]
      course
      {:error :not-found-data})))

(defmethod fetch :courses [_ {:keys [course-ids]}]
  (go
    (if-let [courses (cs/courses-by-id course-ids courses)]
      courses
      {:error :not-found-data})))

(defmethod fetch :resource [_ {:keys [url]}]
  (go (r/select-resource url all-resources)))

(defmethod fetch :resources [_ {:keys [resources urls tags]}]
  (let [urls (map :url resources)]
    (go
      (if tags
        all-resources
        (r/select-resources urls all-resources)))))
