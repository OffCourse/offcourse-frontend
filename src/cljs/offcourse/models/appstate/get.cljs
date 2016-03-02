(ns offcourse.models.appstate.get
  (:refer-clojure :exclude [get])
  (:require [com.rpl.specter :refer [ALL select-first]]
            [medley.core :as medley]
            [offcourse.models.datastore.paths :as paths]))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :collection-names [{:keys [collection-names]} {:keys [collection-type]}]
  (when collection-names
    (if (or (not collection-type) (= collection-type :all))
      collection-names
      (collection-type collection-names))))

(defmethod get :collection [{:keys [collections] :as ds} {:keys [collection]}]
  (when collections
    (let [{:keys [collection-type collection-name]} collection]
      (select-first (paths/collection collection-type collection-name) ds))))

(defmethod get :courses [{:keys [courses] :as ds} {:keys [course-ids]}]
  (when courses
    (when-let [courses (keep #(select-first (paths/course %) ds) course-ids)]
      (if (empty? courses) nil courses))))

(defmethod get :course [{:keys [courses] :as ds} {:keys [course]}]
  (when courses
    (let [{:keys [course-id curator hashtag]} course]
      (or (select-first (paths/course course-id) ds)
          (select-first (paths/course curator hashtag) ds)))))

(defmethod get :checkpoint [{:keys [courses] :as ds} {:keys [checkpoint]}]
  (when courses
    (let [{:keys [course-id checkpoint-id]} checkpoint]
      (select-first (paths/checkpoint course-id checkpoint-id) ds))))

(defmethod get :resources [{:keys [resources]} {:keys [resource-ids]}]
  (when resources
    (when-let [resources (keep #(get-in resources [%]) resource-ids)]
      (if (empty? resources) nil resources))))

(defmethod get :resource [{:keys [resources]} {:keys [resource]}]
  (when resources
    (when-let [{:keys [resource-id]} resource]
      (get-in resources [resource-id]))))

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
