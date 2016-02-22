(ns offcourse.models.datastore.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.datastore.paths :as paths]
            [com.rpl.specter :refer [ALL transform select-first]]))

(defn add-new-checkpoint [ds course-id]
  (transform (paths/checkpoints course-id)
             #(conj % {:checkpoint-id :new})
             ds))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :checkpoint [{:keys [courses] :as ds} {:keys [checkpoint] :as query}]
  (if (= (:checkpoint-id checkpoint) :new)
    (add-new-checkpoint ds (:course-id checkpoint))
    ds))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})

