(ns offcourse.viewmodels.checkpoint-view.validatable
  (:require [offcourse.protocols.queryable :as qa]))

(defn missing-data [{:keys [course checkpoint-id] :as vm}]
  (let [next-missing-field (first (keys (qa/check vm)))
        resource-id (->> (:checkpoints course)
                         (some #(if (= (:checkpoint-id %) checkpoint-id) %))
                         :resource-id)
        payload {:type next-missing-field}]
    (case next-missing-field
      :labels (assoc payload :type :collection-names)
      :course (assoc payload :course course)
      :resource (assoc payload :resource-id resource-id)
      nil)))
