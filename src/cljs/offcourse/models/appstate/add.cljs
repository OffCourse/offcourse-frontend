(ns offcourse.models.appstate.add
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.paths :as paths]
            [com.rpl.specter :refer [ALL select-first setval transform select-first]]
            [offcourse.models.course.index :as co]
            [offcourse.models.collection :as cl]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.checkpoint :as cp]))

(defn add-course [store course]
  (update-in store [:courses] #(conj % course)))

(defn add-resource [store resource]
  (update-in store [:resources] #(conj % resource)))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :collection [store {:keys [collection] :as q}]
  (transform [:collections] #(conj % (cl/new collection)) store))

(defmethod add :courses [store {:keys [courses] :as q}]
  (reduce add-course store courses))

(defmethod add :course [{:keys [user] :as store} {:keys [course] :as query}]
  (if (va/valid? course)
    (-> store
        (update-in [:viewmodel :dependencies :course] #(with-meta % {:saved? true}))
        (update :courses #(conj % course))
        (qa/refresh :collections course))
    store))

  (defmethod add :resources [store {:keys [resources]}]
  (reduce add-resource store resources))

(defmethod add :resource [store {:keys [resource]}]
  (update-in store [:resources] #(conj % resource)))

(defmethod add :default [_ _]
  {:type :error
   :error :query-not-supported})
