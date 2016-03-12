(ns offcourse.models.course.index
  (:require [offcourse.models.checkpoint :refer [Checkpoint]]
            [offcourse.models.course.add :as add-impl]
            [offcourse.models.course.get :as get-impl]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]))

(schema/defrecord Course
    [course-id    :- schema/Num
     base-id      :- schema/Num
     course-slug  :- schema/Str
     timestamp    :- schema/Int
     version      :- [schema/Num]
     revision     :- schema/Num
     curator      :- schema/Keyword
     goal         :- schema/Any
     flags        :- #{schema/Keyword}
     forked-from  :- (schema/maybe schema/Num)
     forks        :- #{schema/Num}
     checkpoints  :- [Checkpoint]]
  Queryable
  (-check [course] (schema/check Course course))
  (-get [course query] (get-impl/get course query))
  (-add [course query] (add-impl/add course query))
  Validatable
  (-valid? [course] (if-not (qa/check course) true false)))

(defn new
  ([defaults] (map->Course defaults))
  ([] (map->Course {})))
