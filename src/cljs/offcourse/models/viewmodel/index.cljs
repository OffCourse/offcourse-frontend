(ns offcourse.models.viewmodel.index
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint.index :as cp]
            [offcourse.models.viewmodel.get :as get-impl]
            [offcourse.models.viewmodel.convertible :as cv-impl]
            [offcourse.models.profile.index :as pf]
            [offcourse.models.dependencies.index :as deps]
            [offcourse.protocols.convertible :as cv :refer [Convertible]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [schema.core :as schema]
            [bidi.bidi :as bidi]))

(schema/defrecord Viewmodel
    [type :- schema/Keyword
     dependencies :- {schema/Keyword schema/Any}]
  Convertible
  (to-url [vm routes] (cv-impl/to-url vm routes))
  Queryable
  (-get [vm query] (get-impl/get vm query)))

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
                                              :checkpoint (cp/new)})})))

(defmethod new :course-view [{:keys [type course]}]
  (map->Viewmodel {:type type
                   :dependencies (deps/new {:course course})}))

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
