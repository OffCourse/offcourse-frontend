(ns offcourse.models.course
  (:require [schema.core :as schema :include-macros true]
            [schema.coerce :as coerce]
            [schema.spec.core :as spec]
            [schema.utils :as s-utils]
            [cljs.core.match :refer-macros [match]]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(defn valid-id? [id]
  (let [[_ uuid curator version] (re-matches #"(.+)/(.+)/(.+)" id)]
    (uuid/valid-uuid? uuid)))

(schema/defrecord Course
    [course-id    :- (schema/pred valid-id?)
     base-id      :- schema/Uuid
     version      :- schema/Num
     curator      :- schema/Keyword
     goal         :- schema/Any
     flags        :- #{schema/Keyword}
     forked-from  :- (schema/maybe (schema/pred valid-id?))
     forks        :- #{(schema/pred valid-id?)}
     checkpoints  :- [Checkpoint]]
  Queryable
  (check [course]
    (schema/check Course course))
  Validatable
  (valid? [course]
    (if-not (qa/check course) true false)))
