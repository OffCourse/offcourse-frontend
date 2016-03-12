(ns offcourse.models.viewmodel.refresh
  (:require [medley.core :as medley]
            [offcourse.models.checkpoint :as cp]))

(def view-hierarchy
  (-> (make-hierarchy)
      (derive :checkpoint-view :new-view)
      (derive :loading-view :new-view)
      (derive :course-view :new-view)
      (derive :collection-view :new-view)))

(defmulti refresh
  (fn [_ {:keys [type]}] type)
  :hierarchy #'view-hierarchy)

(defn refresh-dependencies [{:keys [course]} query-dependencies]
  (medley/map-kv (fn [dep-name dep]
                     (if (= dep-name :checkpoint)
                       (let [checkpoint (assoc dep :checkpoint-id (-> course :checkpoints count))]
                         [:course (update course :checkpoints
                                          #(conj % (cp/map->Checkpoint checkpoint)))])
                       [dep-name dep]))
                 query-dependencies))

(defmethod refresh :update-deps [vm query]
  (assoc vm
         :type (:type vm)
         :dependencies (refresh-dependencies
                        (:dependencies vm) (:dependencies query))))

(defmethod refresh :new-view [vm query]
  (assoc vm :type
         (:type query)
         :dependencies (:dependencies query)))

(defmethod refresh :default [_ _]
  {:type :error :error :query-not-supported})
