(ns offcourse.models.viewmodel.refresh
  (:require [medley.core :as medley]
            [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]))

(def view-hierarchy
  (-> (make-hierarchy)
      (derive :checkpoint-view :new-view)
      (derive :loading-view    :new-view)
      (derive :course-view     :new-view)
      (derive :collection-view :new-view)))

(defmulti refresh
  (fn [_ {:keys [type]}] type)
  :hierarchy #'view-hierarchy)

(defn refresh-dependencies [{:keys [course]} action]
  (medley/map-kv (fn [dep-name dep]
                   (case dep-name
                     :checkpoint [:course (qa/add course :checkpoint dep)]
                     :checkpoints [:course (qa/remove course :checkpoints dep)]
                     [:course (merge course (dissoc action :type))]))
                 (dissoc action :type)))

(defmethod refresh :update-deps [{:keys [dependencies course] :as vm}
                                 {:keys [actions] :as q}]
  (assoc vm
         :type (:type vm)
         :dependencies (refresh-dependencies dependencies actions)))

(defmethod refresh :new-view [vm {:keys [dependencies] :as query}]
  (let [{:keys [course]} dependencies]
    (assoc vm :type
           (:type query)
           :dependencies (if course
                           (assoc dependencies :course (co/new course))
                           dependencies))))

(defmethod refresh :default [_ _]
  {:type :error :error :query-not-supported})
