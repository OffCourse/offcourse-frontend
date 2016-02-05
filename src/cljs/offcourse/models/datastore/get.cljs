(ns offcourse.models.datastore.get
  (:refer-clojure :exclude [get])
  (:require [com.rpl.specter :refer [select select-first filterer ALL]]))

(defn course-by-id [courses id]
  (select-first [ALL #(= (:course-id %) id)] courses))

(defn course-by-curator-and-hashtag [courses curator hashtag]
  (select-first [ALL #(and (= (:hashtag %) hashtag)
                           (= (:curator %) curator))] courses))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :collection [{:keys [collections]} {:keys [collection]}]
  (let [{:keys [collection-type collection-name]} collection]
    (get-in collections [collection-type collection-name])))

(defmethod get :courses [{:keys [courses]} {:keys [course-ids]}]
  (when-let [courses (keep #(course-by-id courses %) course-ids)]
    (if (empty? courses) nil courses)))

(defmethod get :course [{:keys [courses]} {:keys [course]}]
  (when-let [{:keys [course-id curator hashtag]} course]
    (or (course-by-id courses course-id)
        (course-by-curator-and-hashtag courses curator hashtag))))

(defmethod get :resources [ds query])
(defmethod get :resource [ds query])

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
