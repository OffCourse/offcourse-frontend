(ns offcourse.models.course
  (:require [schema.core :as schema :include-macros true]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.protocols.convertible :as ci :refer [Convertible]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(schema/defrecord Course
    [course-id :- schema/Str
     base-id :- schema/Str
     version :- schema/Num
     curator :- schema/Str
     goal :- schema/Str
     flags :- #{schema/Keyword}
     checkpoints :- schema/Any]
  Queryable
  (check [course]
    (schema/check Course course))
  Convertible
  (to-js [course]
    (clj->js course))
  (to-json [course]
    (.stringify js/JSON (ci/to-js course)))
  Validatable
  (valid? [course]
    (if-not (qa/check course) true false)))

(defn remove-db-data [{:keys [_id _rev] :as course-map}]
  (if (and _id _rev)
    (dissoc course-map :_id :_rev)
    course-map))

(defn convert-flags [flags]
  (->> flags
       (map keyword)
       (into #{})))

(defn from-map [{:keys [base-id version flags] :as course-map}]
  (let [course (-> course-map
                   remove-db-data
                   (assoc :flags (convert-flags flags))
                   (assoc :course-id (str base-id "-" version)))]
  (map->Course course)))

(defn from-js [course-js]
  (-> course-js
      (js->clj :keywordize-keys true)
      from-map))

(defn from-json [course-json]
  (-> course-json
      (js/JSON.parse)
      from-js))
