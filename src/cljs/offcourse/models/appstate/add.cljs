(ns offcourse.models.appstate.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course :as co]
            [offcourse.models.checkpoint :as cp]))

(defn add-new-checkpoint [as course-id]
  (if (select-first (paths/checkpoint course-id :new) as)
    (setval (paths/checkpoint course-id :new) cp/placeholder as)
    (transform [(paths/course course-id) :checkpoints] #(conj % cp/placeholder) as)))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :checkpoint [{:keys [courses] :as as} {:keys [checkpoint] :as query}]
  (if (= (:checkpoint-id checkpoint) :new)
    (add-new-checkpoint as (:course-id checkpoint))
    as))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})

