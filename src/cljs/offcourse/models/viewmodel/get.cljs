(ns offcourse.models.viewmodel.get
  (:refer-clojure :exclude [get]))

(defmulti get (fn [_ {:keys [type] :as q}] type))

(defmethod get :course [{:keys [dependencies] :as vm} query]
  (get-in vm [:dependencies :course]))

(defmethod get :profile [{:keys [dependencies] :as vm} query]
  (get-in vm [:dependencies :profile]))

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
