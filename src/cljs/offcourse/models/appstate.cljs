(ns offcourse.models.appstate
  (:require [schema.core :as schema]
            [offcourse.protocols.validatable :refer [Validatable]]))

(schema/defrecord Appstate
    [type           :- schema/Keyword
     data-deps      :- {schema/Keyword schema/Any}]
  Validatable
  (-valid? [as] (if-not (schema/check Appstate as) true false)))

(defn new [view-type & data-deps]
  (map->Appstate {:type view-type
                  :data-deps (apply hash-map data-deps)}))
