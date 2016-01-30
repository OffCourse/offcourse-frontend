(ns offcourse.viewmodels.course-view.validatable
  (:require [offcourse.protocols.queryable :as qa]
            [cljs.pprint :as pprint]))

(defn missing-data [{:keys [course] :as vm}]
  (let [next-missing-field (first (keys (qa/check vm)))
        resource-ids (->> (:checkpoints course)
                          (map (comp str :resource-id)))
        payload {:type next-missing-field}]
    (case next-missing-field
      :labels (assoc payload :type :collection-names)
      :course (assoc payload :course course)
      :resources (assoc payload :resource-ids resource-ids)
      nil)))
