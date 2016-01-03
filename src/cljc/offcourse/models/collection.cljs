(ns offcourse.models.collection
  (:require [schema.core :as schema :include-macros true]
            [offcourse.models.course :as co]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Collection
    [collection-name :- schema/Keyword
     collection-type :- schema/Keyword
     collection-ids  :- #{(schema/pred co/valid-id?)}])
