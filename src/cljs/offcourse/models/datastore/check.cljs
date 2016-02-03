(ns offcourse.models.datastore.check
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select select-first filterer ALL]]))

(defn member-ids [collection]
  (->> (keys collection)
       (into #{})))

(defn has-items? [collection ids]
  (set/superset? (member-ids collection) ids))

(defn has-course? [courses {:keys [course-id curator hashtag] :as course}]
  (if courses
    (let [course (or (select-first [ALL #(= (:course-id %) course-id)] courses)
                     (select-first [ALL #(and (= (:hashtag %) hashtag)
                                              (= (:curator %) curator))] courses))]
      (if course true false))
    false))

(defn has-courses? [courses course-ids]
  (->> course-ids
       (map (fn [id] {:course-id id}))
       (map #(has-course? courses %))
       (every? true?)))

(defmulti check (fn [_ {:keys [type]}] type))

(defmethod check :collection-names [{:keys [has-collection-names?]} query]
  has-collection-names?)

(defmethod check :collection [{:keys [collections]} {:keys [collection]}]
  (let [{:keys [collection-type collection-name]} collection]
    (if-let [course-ids (get-in collections [collection-type collection-name :course-ids])]
      (> (count course-ids) 0))))

(defmethod check :courses [{:keys [courses]} {:keys [course-ids]}]
  (when course-ids
    (has-courses? courses course-ids)))

(defmethod check :course [{:keys [courses] :as store} {:keys [course]}]
  (has-course? courses course))

(defmethod check :resources [{:keys [resources]} {:keys [resource-ids]}]
  (when resource-ids
    (has-items? resources resource-ids)))

(defmethod check :resource [{:keys [resources]} {:keys [resource]}]
  (when-let [{:keys [resource-id]} resource]
    (has-items? resources #{resource-id})))

(defmethod check :default [{:keys [resources]} {:keys [resource-id]}]
  {:type :error
   :error :query-not-supported})
