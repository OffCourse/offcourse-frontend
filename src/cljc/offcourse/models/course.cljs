(ns offcourse.models.course
  (:require [schema.core :as schema :include-macros true]))

(schema/defrecord Course
    [course-id :- schema/Str
     base-id :- schema/Str
     version :- schema/Num
     curator :- schema/Str
     goal :- schema/Str
     flags :- #{schema/Keyword}
     checkpoints :- {schema/Int schema/Any}])

(def check (schema/checker Course))
