(ns offcourse.models.course.index
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [ALL select-first]]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]
            [offcourse.models.course.get :as get-impl]))

(schema/defrecord Course
    [course-id    :- schema/Num
     base-id      :- schema/Num
     slug         :- schema/Str
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
  Validatable
  (-valid? [course] (if-not (qa/check course) true false)))

(defn new
  ([defaults] (map->Course defaults))
  ([] (map->Course {})))
