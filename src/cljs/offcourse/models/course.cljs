(ns offcourse.models.course
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [ALL select-first]]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]))

(schema/defrecord Course
    [course-id    :- schema/Int
     base-id      :- schema/Int
     hashtag      :- schema/Keyword
     description  :- schema/Str
     timestamp    :- schema/Int
     version      :- [schema/Int]
     revision     :- schema/Int
     curator      :- schema/Keyword
     goal         :- schema/Any
     flags        :- #{schema/Keyword}
     forked-from  :- (schema/maybe schema/Num)
     forks        :- #{schema/Int}
     checkpoints  :- [Checkpoint]]
  {(schema/optional-key :tags) #{schema/Keyword}}
  Queryable
  (-check [course] (schema/check Course course))
  Validatable
  (-valid? [course]
    (if-not (qa/check course) true false)))

(defn get-tags [course]
  (->> course
       :checkpoints
       (map :tags)
       (apply set/union)))

(defn get-resource-urls [course]
  (->> course
       :checkpoints
       (map :url)))

(defn get-resource-url [course checkpoint-id]
  (when (:checkpoints course)

    (select-first [:checkpoints ALL #(= (:checkpoint-id %) checkpoint-id) :url] course)))

(defn get-checkpoint [course checkpoint-id]
  (->> (:checkpoints course)
       (some #(if (= (:checkpoint-id %) checkpoint-id) %))))

(defn add-placeholder-checkpoint [course]
  (update course :checkpoints #(conj % (cp/placeholder))))
