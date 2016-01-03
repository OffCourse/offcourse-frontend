(ns offcourse.helpers.converters
  (:require [schema.core :as schema :include-macros true]
            [schema.coerce :as coerce]
            [schema.spec.core :as spec]
            [schema.utils :as s-utils]
            [cljs.core.match :refer-macros [match]]
            [cljs-uuid-utils.core :as uuid]
            [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.checkpoint :as cp :refer [Checkpoint]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(defn remove-db-data [course-map]
  (match [course-map]
         [{:_id _ :_rev _}] (dissoc course-map :_id :_rev)
         [{:_id _}] (dissoc course-map :_id)
         [{:_rev _ }] (dissoc course-map :_rev)
         :else course-map))

(defn convert-json-field [schema data]
  (if-let [coerce (coerce/json-coercion-matcher schema)]
    (coerce data)
    data))

(defn convert-uuid-field [{:keys [uuid] :as data}]
  (uuid/make-uuid-from (or uuid data)))

(defn coerce-and-validate [schema matcher data]
  (let [coercer (coerce/coercer schema matcher)
        result  (coercer data)]
    (if (s-utils/error? result)
      (println "Value does not match schema: %s"
                                 (s-utils/error-val result))
      result)))

(defn convert-course-field [schema data]
  (->> (js->clj data :keywordize-keys true)
       remove-db-data
       co/map->Course))

(defn course-walker [input-schema]
  (spec/run-checker
   (fn [schema params]
     (let [checker (spec/checker (schema/spec schema) params)]
       (fn [data]
         (condp = schema
           Course (->> data
                       (convert-course-field schema)
                       checker)
           Checkpoint (cp/map->Checkpoint data)
           UUID  (convert-uuid-field data)
           (convert-json-field schema data)))))
   true
   input-schema))

(defn course-from-js [course-json]
  (->> course-json
       (coerce-and-validate Course course-walker)))
