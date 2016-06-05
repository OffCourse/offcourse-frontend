(ns offcourse.models.appstate.refresh
  (:require [offcourse.protocols.queryable :as qa]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :viewmodel [{:keys [user] :as state} {:keys [viewmodel] :as query}]
  (-> state (assoc :viewmodel viewmodel)))

(defmethod refresh :data [store {:keys [data] :as query}]
  (qa/add store data))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
