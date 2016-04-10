(ns offcourse.models.viewmodel.index
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint.index :as cp]
            [offcourse.models.profile.index :as pf]
            [offcourse.models.dependencies.index :as deps]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [schema.core :as schema]))

(schema/defrecord Viewmodel
    [type :- schema/Keyword
     dependencies :- {schema/Keyword schema/Any}]
  Queryable
  (-get [vm query] (get-in vm [:dependencies :course])))

(def defaults
  {:dependencies (deps/new)})

(defmulti new
  (fn [{:keys [type] :as q}] type))

(defmethod new :collection-view [{:keys [type collection]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new {:collection collection})}))

(defmethod new :new-course-view [{:keys [type user-name course]}]
  (let [course (-> course
                   (assoc :curator user-name)
                   co/new)]
    (map->Viewmodel {:type type
                     :dependencies (deps/new {:course course
                                              :checkpoint (cp/new {:tags #{}})})})))

(defmethod new :checkpoint-view [{:keys [type course checkpoint]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new {:course course
                                            :checkpoint checkpoint})}))

(defmethod new :loading-view [{:keys [type]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new)}))

(defmethod new :new-user-view [{:keys [type]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new {:profile (pf/new {})})}))
