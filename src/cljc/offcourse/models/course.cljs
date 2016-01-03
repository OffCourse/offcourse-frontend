(ns offcourse.models.course
  (:require [schema.core :as schema :include-macros true]
            [schema.coerce :as coerce]
            [schema.spec.core :as spec]
            [schema.utils :as s-utils]
            [cljs.core.match :refer-macros [match]]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.convertible :as ci :refer [Convertible]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(def CourseMetaSchema
  {:curator schema/Keyword
   :base-id schema/Uuid
   :version schema/Num})

(schema/defrecord Course
    [course-id :- schema/Str
     base-id :- schema/Uuid
     version :- schema/Num
     curator :- schema/Keyword
     goal :- schema/Any
     flags :- #{schema/Keyword}
     forked-from :- (schema/maybe CourseMetaSchema)
     forks :- #{CourseMetaSchema}
     checkpoints :- [Checkpoint]]
  Queryable
  (check [course]
    (schema/check Course course))
  Convertible
  (to-js [course]
    (clj->js course))
  Validatable
  (valid? [course]
    (if-not (qa/check course) true false)))
