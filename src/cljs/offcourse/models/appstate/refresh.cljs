(ns offcourse.models.appstate.refresh
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select-first transform]]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.viewmodel.index :as vm]))

(def data-hierarchy
  (-> (make-hierarchy)

      (derive :add-checkpoint    :dependencies)
      (derive :delete-checkpoint :dependencies)
      (derive :update-goal       :dependencies)
      (derive :update-curator    :dependencies)
      (derive :update-task       :dependencies)
      (derive :update-url        :dependencies)
      (derive :update-tag        :dependencies)
      (derive :reset-checkpoint  :dependencies)
      (derive :reset-tag         :dependencies)
      (derive :add-tag           :dependencies)
      (derive :update-user-name  :dependencies)

      (derive :toggle-checkpoint :course)

      (derive :collection-view   :viewmodel)
      (derive :checkpoint-view   :viewmodel)
      (derive :course-view       :viewmodel)
      (derive :new-course-view   :viewmodel)
      (derive :new-user-view     :viewmodel)
      (derive :loading-view      :viewmodel)

      (derive :courses           :data)
      (derive :resources         :data)))

(defmulti refresh (fn [_ {:keys [type]}] type)
  :hierarchy #'data-hierarchy)

(defmethod refresh :viewmodel [{:keys [user] :as state} {:keys [viewmodel] :as query}]
  (-> state
      (assoc :viewmodel viewmodel)))

(defmethod refresh :data [store {:keys [data] :as query}]
  (qa/add store data))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
