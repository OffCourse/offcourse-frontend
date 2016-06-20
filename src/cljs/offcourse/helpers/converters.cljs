(ns offcourse.helpers.converters
  (:require [bidi.bidi :as bidi]
            [cljs-uuid-utils.core :as uuid]
            [cljs.core.match :refer-macros [match]]
            [offcourse.models.checkpoint.index :as cp :refer [Checkpoint]]
            [offcourse.models.collection :as cl :refer [Collection]]
            [offcourse.models.profile.index :as pf :refer [Profile]]
            [offcourse.models.course.index :as co :refer [Course]]
            [offcourse.models.resource.index :as rs :refer [Resource]]
            [schema.coerce :as coerce]
            [schema.core :as schema :include-macros true]
            [schema.utils :as s-utils]))

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

(defn resource-matcher [schema]
  (when (= Resource schema)
    (coerce/safe
     (fn [data]
       (->> data
            rs/map->Resource)))))

(defn user-profile-matcher [schema]
  (when (= Profile schema)
    (coerce/safe
     (fn [data]
       (->> data
            pf/map->Profile)))))

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
(def user-profile-walker
  (coerce/first-matcher [user-profile-matcher
                         coerce/json-coercion-matcher]))

(def resource-walker
  (coerce/first-matcher [resource-matcher
                         uuid-matcher
                         coerce/json-coercion-matcher]))

(def collection-walker
  (coerce/first-matcher [collection-matcher coerce/json-coercion-matcher]))

(defn to-user-profile [obj]
  (coerce-and-validate obj Profile user-profile-walker))

(defn to-course [obj]
  (coerce-and-validate obj Course course-walker))

(defn to-resource [obj]
  (coerce-and-validate obj Resource resource-walker))

(defn to-collection [{:keys [course-ids] :as obj}]
  (coerce-and-validate (dissoc obj :course-ids) Collection collection-walker))

(defmulti to-url (fn [{:keys [type] :as query} _] type))

(defmethod to-url :new-user [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes :new-user-view))

(defmethod to-url :new-course [{:keys [type new-course] :as vm} routes]
  (bidi/path-for routes :new-course-view :curator (:curator new-course)))

(defmethod to-url :course [{:keys [type course] :as vm} routes]
  (let [{:keys [course-slug curator]} course]
    (bidi/path-for routes :course-view :curator curator :course-slug course-slug)))

(defmethod to-url :checkpoint [{:keys [type course checkpoint] :as vm} routes]
  (let [{:keys [course-slug curator]} course
        {:keys [checkpoint-slug]} checkpoint]
    (bidi/path-for routes :checkpoint-view :curator curator :course-slug course-slug :checkpoint-slug checkpoint-slug)))

(defmethod to-url :collection [{:keys [type collection] :as vm} routes]
  (let [{:keys [collection-type collection-name]} collection]
    (bidi/path-for routes :collection-view :collection-type collection-type :collection-name collection-name)))

(defmethod to-url :loading [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes type))
