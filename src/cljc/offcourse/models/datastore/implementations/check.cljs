(ns offcourse.models.datastore.implementations.check
  (:require [clojure.set :as set]))

(defn member-ids [collection]
  (->> (keys collection)
       (map str)
       (into #{})))

(defn has-items? [collection ids] (set/superset? (member-ids collection) ids))

(defmulti check (fn [_ {:keys [type]}] type))

(defmethod check :collection-names [{:keys [has-collection-names?]} query]
  has-collection-names?)

(defmethod check :collection [{:keys [collections]} {:keys [collection-type collection-name]}]
  (let [course-ids (get-in collections [collection-type collection-name :course-ids])]
    (> (count course-ids) 0)))

(defmethod check :courses [{:keys [courses]} {:keys [course-ids]}]

  (has-items? courses course-ids))

(defmethod check :course [{:keys [courses]} {:keys [course-id]}]
  (has-items? courses #{course-id}))

(defmethod check :resources [{:keys [resources]} {:keys [resource-ids]}]
  (has-items? resources resource-ids))

(defmethod check :resource [{:keys [resources]} {:keys [resource-id]}]
  (has-items? resources #{resource-id}))
