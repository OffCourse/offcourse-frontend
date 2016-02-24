(ns offcourse.models.datastore.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.datastore.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course :as co]
            [offcourse.models.checkpoint :as cp]))

(defn add-new-checkpoint [ds course-id]
  (if (select-first (paths/checkpoint course-id :new) ds)
    (setval (paths/checkpoint course-id :new) cp/placeholder ds)
    (transform [(paths/course course-id) :checkpoints] #(conj % cp/placeholder) ds)))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :checkpoint [{:keys [courses] :as ds} {:keys [checkpoint] :as query}]
  (if (= (:checkpoint-id checkpoint) :new)
    (add-new-checkpoint ds (:course-id checkpoint))
    ds))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})

