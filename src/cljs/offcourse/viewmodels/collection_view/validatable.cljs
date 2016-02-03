(ns offcourse.viewmodels.collection-view.validatable
  (:require [offcourse.protocols.queryable :as qa]
            [clojure.set :as set]))

(defn missing-ids [{:keys [course-ids]} courses]
  (when course-ids
    (set/difference course-ids (into #{} (map :course-id courses)))))

(defn missing-data [{:keys [collection courses] :as vm}]
  (let [missing-ids        (missing-ids collection courses)
        next-missing-field (or (first (keys (qa/check vm)))
                               (when-not (empty? missing-ids) :courses))
        payload            {:type next-missing-field}]
    (case next-missing-field
      :labels     (assoc payload :type :collection-names)
      :collection (assoc payload :collection collection)
      :courses    (assoc payload :course-ids missing-ids)
      nil)))
