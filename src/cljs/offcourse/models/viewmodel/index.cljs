(ns offcourse.models.viewmodel.index
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.models.dependencies.index :as deps]
            [medley.core :as medley]
            [offcourse.models.course.index :as co]))

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

(defmethod new :course-view [{:keys [type user-name course]}]
  (let [course (-> course
                   (assoc :curator user-name)
                   co/new)]
    (map->Viewmodel {:type type
                     :dependencies (deps/new {:course course})})))

(defmethod new :checkpoint-view [{:keys [type course checkpoint]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new {:course course
                                            :checkpoint checkpoint})}))

(defmethod new :loading-view [{:keys [type]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new)}))
