(ns offcourse.models.viewmodel.refresh
  (:require [medley.core :as medley]
            [offcourse.models.checkpoint :as cp]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.course.index :as co]))

(def view-hierarchy
  (-> (make-hierarchy)
      (derive :checkpoint-view :new-view)
      (derive :loading-view    :new-view)
      (derive :course-view     :new-view)
      (derive :collection-view :new-view)))

(defmulti refresh
  (fn [_ {:keys [type]}] type)
  :hierarchy #'view-hierarchy)

(defn refresh-dependencies [{:keys [course]} query-dependencies]
  (medley/map-kv (fn [dep-name dep]
                     (if (= dep-name :checkpoint)
                       [:course (qa/add course :checkpoint dep)]
                       [:course (merge course query-dependencies)]))
                 query-dependencies))

(defmethod refresh :update-deps [{:keys [course] :as vm} query]
  (assoc vm
         :type (:type vm)
         :dependencies (refresh-dependencies
                        (:dependencies vm) (:dependencies query))))

(defmethod refresh :new-view [vm {:keys [dependencies] :as query}]
  (let [{:keys [course]} dependencies]
    (assoc vm :type
           (:type query)
           :dependencies (if course
                           (assoc dependencies :course (co/new course))
                           dependencies))))

(defmethod refresh :default [_ _]
  {:type :error :error :query-not-supported})
