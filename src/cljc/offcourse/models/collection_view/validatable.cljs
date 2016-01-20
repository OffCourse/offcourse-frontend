(ns offcourse.models.collection-view.validatable
  (:require [offcourse.protocols.queryable :as qa]
            [clojure.set :as set]))

(defn missing-data [{:keys [collection courses] :as vm}]
  (let [{:keys [collection-name collection-type course-ids]} collection
        course-ids (when course-ids
                     (set/difference course-ids (into #{} (map :course-id courses))))
        next-missing-field (or (first (keys (qa/check vm)))
                               (when-not (empty? course-ids) :courses))
        payload {:type next-missing-field}]
    (case next-missing-field
      :labels     (assoc payload :type :collection-names)
      :collection (assoc payload :collection-name collection-name
                         :collection-type collection-type)
      :courses    (assoc payload :course-ids course-ids)
      nil)))
