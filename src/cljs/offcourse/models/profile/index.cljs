(ns offcourse.models.profile.index
  (:require [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema :include-macros true]
            [cuerdas.core :as str]))

(schema/defrecord Profile
    [user-name :- schema/Keyword]
  Validatable
  (-valid? [{:keys [user-name] :as profile}]
    (and (not (qa/check profile)) (> (count (name user-name)) 3)))
  Queryable
  (-check [profile] (schema/check Profile profile))
  (-refresh [profile {:keys [user-name] :as query}]
    (assoc profile :user-name (keyword (str/slugify user-name)))))

(defn new [overrides] (map->Profile overrides))
