(ns offcourse.datastore.models.store
  (:require [offcourse.models.course :refer [Course]]
            [offcourse.protocols.queryable :refer [Queryable]]
            [offcourse.models.resource :refer [Resource]]
            [schema.core :as schema]))

(defn course-ids [store]
  (->> store
       :courses
       (map :course-id)
       (into #{})))

(schema/defrecord Store
    [collections :- {(schema/enum :flags :tags :curators) schema/Any}
     courses     :- [schema/Str Course]
     resources   :- {schema/Str Resource}]
  Queryable
  (check [this {:keys [course-id]}] (contains? (course-ids this) course-id))
  (refresh [this {:keys [course]}] (update-in this [:courses] #(conj % course))))

(defn new-store []
  (->Store {} [] []))
