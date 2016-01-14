(ns offcourse.models.resource
  (:require [schema.core :as schema]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable   :as qa :refer [Queryable]]))

(schema/defrecord Resource
    [resource-id   :- schema/Str
     resource-type :- schema/Keyword
     url           :- schema/Str
     title         :- schema/Str
     authors       :- [schema/Str]
     tags          :- #{schema/Keyword}
     content       :- schema/Any]
  Queryable
  (check [resource]
    (schema/check Resource resource))
  Validatable
  (valid? [resource]
    (if-not (qa/check resource) true false)))
