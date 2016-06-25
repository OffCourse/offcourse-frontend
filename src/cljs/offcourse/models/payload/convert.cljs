(ns offcourse.models.payload.convert
  (:require [cljs-uuid-utils.core :as uuid]
            [offcourse.models.checkpoint.index :as cp :refer [Checkpoint]]
            [offcourse.models.collection :as cl :refer [Collection]]
            [offcourse.models.course.index :as co :refer [Course]]
            [offcourse.models.payload.index :as pl]
            [offcourse.models.profile.index :as pf :refer [Profile]]
            [offcourse.models.resource.index :as rs :refer [Resource]]
            [schema.coerce :as coerce]
            [schema.core :as schema :include-macros true]
            [schema.utils :as s-utils]))

(defn user-profile-matcher [schema]
  (when (= Profile schema)
    (coerce/safe
     (fn [data]
       (->> data
            pf/map->Profile)))))

(def user-profile-walker
  (coerce/first-matcher [user-profile-matcher
                         coerce/json-coercion-matcher]))

(defn to-user-profile [obj]
  (coerce-and-validate (dissoc obj :user-id) Profile user-profile-walker))
