(ns offcourse.models.resource.index
  (:require [schema.core :as schema]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable   :as qa :refer [Queryable]]))

(schema/defrecord Resource
    [url              :- schema/Str
     tasks            :- #{schema/Str}
     checkpoint-count :- schema/Num
     tags             :- #{schema/Keyword}]
  {(schema/optional-key :type) schema/Keyword
   (schema/optional-key :description) schema/Str
   (schema/optional-key :title) schema/Str
   (schema/optional-key :authors) [schema/Str]
   (schema/optional-key :content) schema/Any}
  Queryable
  (-check [resource] (schema/check Resource resource))
  Validatable
  (-valid? [resource] (if-not (qa/check resource) true false)))

(defn new [{:keys [url task tags]}] (map->Resource {:url url
                                                    :tasks #{task}
                                                    :tags tags
                                                    :checkpoint-count 1}))
