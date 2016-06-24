(ns offcourse.adapters.fakedb.implementations.queryable
  (:require [ajax.core :refer [GET]]
            [cljs.core.async :refer [<! >! chan]]
            [clojure.string :as str]
            [clojure.walk :as walk]
            [offcourse.adapters.fakedb.collections :as cl]
            [offcourse.adapters.fakedb.courses :as cs]
            [offcourse.adapters.fakedb.resources :as r])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defonce courses   (cs/courses))
(defonce all-resources (r/resources courses))
(defonce collections (cl/collections courses))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :user-profile [_ _]
  (go
      {:type :user-profile
       :user-profile {:user-name "yeehaa"}}))

(defmethod fetch :collection [_ {:keys [collection]}]
  (go
    (let [{:keys [collection-name collection-type]} collection
          course-ids (get-in collections [collection-type collection-name])]
      {:type :courses
       :courses (cs/courses-by-id course-ids courses)})))

(defmethod fetch :course [_ {:keys [course]}]
  (go
    (if-let [course (or (cs/course-by-id course courses)
                        (cs/course-by-curator-and-slug course courses))]
      {:type :course
       :course course}
      {:error :not-found-data})))

(defmethod fetch :courses [_ {:keys [course-ids]}]
  (go
    (if-let [courses (cs/courses-by-id course-ids courses)]
      {:type :courses
       :courses courses}
      {:error :not-found-data})))
