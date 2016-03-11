(ns offcourse.models.viewmodel.refresh
  (:require [medley.core :as medley]
            [offcourse.models.viewmodel.index :as vm]))

(def view-hierarchy
  (-> (make-hierarchy)
      (derive :checkpoint-view :view)
      (derive :collection-view :view)))

(defmulti refresh
  (fn [_ {:keys [type]}] type)
  :hierarchy #'view-hierarchy)

(defn refresh-dependencies [{:keys [course]} query-dependencies]
  (medley/map-kv (fn [dep-name dep]
                   (if (= dep-name :checkpoint)
                     [:course (update course :checkpoints #(conj % dep))]
                     [dep-name dep]))
                 query-dependencies))

(defmethod refresh :course-view [vm query]
  (vm/new {:type (:type query)
           :dependencies (refresh-dependencies
                          (:dependencies vm) (:dependencies query))}))

(defmethod refresh :view [vm query]
  (vm/new {:type (:type query)
           :dependencies (:dependencies query)}))

(defmethod refresh :default [_ _]
  {:type :error :error :query-not-supported})
