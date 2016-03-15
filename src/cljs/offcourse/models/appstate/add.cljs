(ns offcourse.models.appstate.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint :as cp]))

(defn add-course [store course]
  (update-in store [:courses] #(conj % course)))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :course [store {:keys [course]}]
  (update-in store [:courses] #(conj % course)))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})
