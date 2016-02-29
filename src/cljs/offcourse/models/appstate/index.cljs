(ns offcourse.models.appstate.index
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :refer [Validatable]]
            [offcourse.models.datastore.index :as ds :refer [Datastore]]
            [offcourse.models.appstate.refresh :as refresh-impl]
            [offcourse.protocols.validatable :as va]))

(defn query [[type data]]
  {:type type
   type data})

(schema/defrecord Appstate
    [view-type      :- schema/Keyword
     data-deps      :- {schema/Keyword schema/Any}
     store          :- Datastore]
  Validatable
  (-valid? [as] (and (empty? (schema/check Appstate as)) (empty? (va/missing-data as))))
  (-missing-data [{:keys [store data-deps]}]
    (let [data-type     (:type data-deps)
          data-present? (qa/check store data-type (data-type data-deps))]
      (if data-present?
        (when (= (:type data-deps) :collection)
          (let [collection (qa/get store :collection (:collection data-deps))
                course-ids (:course-ids collection)]
            (when-not (qa/check store {:type       :courses
                                       :course-ids course-ids})
              {:type       :courses
               :course-ids course-ids})))
        data-deps)))
  Queryable
  (-refresh [as query] (refresh-impl/refresh as query)))

(defn new
  ([] (->Appstate :loading-view nil (ds/new)))
  ([view-type & data]
   (let [data (apply hash-map data)]
     (map->Appstate {:type view-type
                     :store (:store data)
                     :data-deps (dissoc data :store)}))))
