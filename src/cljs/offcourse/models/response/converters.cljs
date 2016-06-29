(ns offcourse.models.response.converters
  (:require [cljs-uuid-utils.core :as uuid]
            [offcourse.models.checkpoint.index :as cp :refer [Checkpoint]]
            [offcourse.models.collection :as cl :refer [Collection]]
            [offcourse.models.course.index :as co :refer [Course]]
            [offcourse.models.profile.index :as pf :refer [Profile]]
            [offcourse.models.resource.index :as rs :refer [Resource]]
            [schema.coerce :as coerce]
            [schema.core :as schema :include-macros true]
            [schema.utils :as s-utils]
            [cljs.spec :as spec]
            [offcourse.specs.resources :as resources]))

(defn coerce-and-validate [data schema matcher]
  (let [coercer (coerce/coercer schema matcher)
        result  (coercer data)]
    (if (s-utils/error? result)
      (println "Value does not match schema: %s"
               (s-utils/error-val result))
      result)))

(defn course-matcher [schema]
  (when (= Course schema)
    (coerce/safe
     (fn [data]
       (->> data
            co/map->Course)))))

(defn collection-matcher [schema]
  (when (= Collection schema)
    (coerce/safe
     (fn [data]
       (->> data
            cl/map->Collection)))))

(defn checkpoint-matcher [schema]
  (when (= Checkpoint schema)
    (coerce/safe
     (fn [data]
       (cp/map->Checkpoint data)))))

(defn uuid-matcher [schema]
  (when (= schema/Uuid schema)
    (coerce/safe
     (fn [{:keys [uuid] :as data}]
       (uuid/make-uuid-from (or uuid data))))))

(def course-walker
  (coerce/first-matcher [course-matcher
                         checkpoint-matcher
                         coerce/json-coercion-matcher]))
(defn to-course [obj]
  (coerce-and-validate obj Course course-walker))

(defn to-courses [obj]
  (keep to-course obj))

(defn to-resource [obj]
  (let [resource (rs/map->Resource obj)]
    resource))

(defn to-resources [obj]
  (keep to-resource obj))
