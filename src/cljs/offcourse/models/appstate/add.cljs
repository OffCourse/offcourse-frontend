(ns offcourse.models.appstate.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course.index :as co]
            [offcourse.models.collection :as cl]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.checkpoint.index :as cp]))

(defn- add-course [store course]
  (if-not (qa/get store :course course)
    (update-in store [:courses] #(conj % course))
    store))

(defn- add-resource [store resource]
  (if-not (qa/get store :resource resource)
    (update-in store [:resources] #(conj % resource))
    store))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :courses [store {:keys [courses]}]
  (reduce add-course store courses))

(defmethod add :course [{:keys [user] :as store} {:keys [course] :as query}]
  (add-course store course))

(defmethod add :resources [store {:keys [resources]}]
  (reduce add-resource store resources))

(defmethod add :resource [store {:keys [resource]}]
  (add-resource store resource))

(defmethod add :user-profile [store {:keys [user-profile]}]
  (assoc store :user user-profile))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})
