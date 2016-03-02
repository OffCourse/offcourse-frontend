(ns offcourse.models.appstate.index
  (:require [offcourse.models.appstate.check :as check-impl]
            [offcourse.models.appstate.get :as get-impl]
            [offcourse.models.appstate.refresh :as refresh-impl]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(defn query [[type data]]
  {:type type
   type data})

(schema/defrecord Appstate
    [view-type      :- schema/Keyword
     view-data      :- {schema/Keyword schema/Any}
     collections    :- [Collection]
     courses        :- [Course]
     resources      :- (schema/maybe {schema/Str Resource})]
  Validatable
  (-valid? [as] (empty? (schema/check Appstate as)))
  (-missing-data [{:keys [view-data courses] :as as}]
    (when-let [data-type (:type view-data)]
      (if-let [data-present? (qa/check as data-type (data-type view-data))]
        (case data-type
          :collection (let [collection (qa/get as :collection (:collection view-data))
                            course-ids (:course-ids collection)
                            query {:type :courses
                                   :course-ids course-ids}]
                        (when-not (qa/check as query) query))
          nil)
        view-data)))


  Queryable
  (-refresh [as query] (refresh-impl/refresh as query))
  (-check [as query] (check-impl/check as query))
  (-get [as query] (get-impl/get as query)))

(defn new
  ([] (->Appstate :loading-view {} [] [] []))
  ([data] (map->Appstate data)))
