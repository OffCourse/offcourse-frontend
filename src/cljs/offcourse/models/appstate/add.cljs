(ns offcourse.models.appstate.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint :as cp]))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})
