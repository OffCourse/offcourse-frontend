(ns offcourse.models.course
  (:require [schema.core :as schema :include-macros true]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.models.checkpoint     :as cp :refer [Checkpoint]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable   :as qa :refer [Queryable]]
            [clojure.set :as set]))

(schema/defrecord Course
    [course-id    :- schema/Int
     base-id      :- schema/Int
     hashtag      :- schema/Keyword
     timestamp    :- schema/Int
     version      :- [schema/Int]
     revision     :- schema/Int
     curator      :- schema/Keyword
     goal         :- schema/Any
     flags        :- #{schema/Keyword}
     forked-from  :- (schema/maybe schema/Num)
     forks        :- #{schema/Int}
     checkpoints  :- [Checkpoint]]
  Queryable
  (check [course] (schema/check Course course))
  Validatable
  (valid? [course]
    (if-not (qa/check course) true false)))

(defn get-tags [course]
  (->> course
       :checkpoints
       (map :tags)
       (apply set/union)))

(defn get-resource-ids [course]
  (->> course
       :checkpoints
       (map :resource-id)))

(defn get-checkpoint [course checkpoint-id]
  (->> (:checkpoints course)
       (some #(if (= (:checkpoint-id %) checkpoint-id) %))))
