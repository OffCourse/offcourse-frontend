(ns offcourse.helpers.converters
  (:require [schema.core :as schema :include-macros true]
            [schema.coerce :as coerce]
            [schema.spec.core :as spec]
            [schema.utils :as s-utils]
            [cljs.core.match :refer-macros [match]]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.resource :as rs :refer [Resource]]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.models.collection :as cl :refer [Collection]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))


(defn remove-db-data [course-map]
  (match [course-map]
         [{:_id _ :_rev _}] (dissoc course-map :_id :_rev)
         [{:_id _}] (dissoc course-map :_id)
         [{:_rev _ }] (dissoc course-map :_rev)
         :else course-map))

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
            remove-db-data
            co/map->Course)))))

(defn resource-matcher [schema]
  (when (= Resource schema)
    (coerce/safe
     (fn [data]
       (->> data
            remove-db-data
            rs/map->Resource)))))

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
                         uuid-matcher
                         coerce/json-coercion-matcher]))

(def resource-walker
  (coerce/first-matcher [resource-matcher
                         uuid-matcher
                         coerce/json-coercion-matcher]))

(def collection-walker
  (coerce/first-matcher [collection-matcher coerce/json-coercion-matcher]))

(defn to-course [obj]
  (coerce-and-validate obj Course course-walker))

(defn to-resource [obj]
  (coerce-and-validate obj Resource resource-walker))

(defn to-collection [arr]
  (coerce-and-validate arr Collection collection-walker))
