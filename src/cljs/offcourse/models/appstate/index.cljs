(ns offcourse.models.appstate.index
  (:require [offcourse.models.appstate.check :as check-impl]
            [offcourse.models.appstate.get :as get-impl]
            [offcourse.models.appstate.add :as add-impl]
            [offcourse.models.appstate.refresh :as refresh-impl]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.models.course :refer [Course]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]
            [offcourse.models.course :as co]))

(defn query [[type data]]
  {:type type
   type data})

(schema/defrecord Appstate
    [site-title     :- schema/Str
     view-type      :- schema/Keyword
     view-data      :- {schema/Keyword schema/Any}
     user           :- {:name (schema/maybe schema/Keyword)}
     collections    :- [Collection]
     courses        :- [Course]
     resources      :- (schema/maybe {schema/Str Resource})
     queries        :- (schema/maybe #{schema/Num})]
  Validatable
  (-valid? [as] (and (empty? (schema/check Appstate as))
                     (not (va/missing-data as))))
  (-missing-data [{:keys [view-data courses] :as as}]
    (when-let [data-type (:type view-data)]
      (if-let [data-present? (qa/check as data-type (data-type view-data))]
        (case data-type
          :collection (let [collection (qa/get as :collection (:collection view-data))
                            course-ids (:course-ids collection)
                            query {:type :courses
                                   :course-ids course-ids}]
                        (when-not (qa/check as query) query))
          :course (let [course       (qa/get as :course (:course view-data))
                        resource-ids (co/get-resource-ids course)
                        query        {:type :resources
                                      :resource-ids resource-ids}]
                    (when-not (or (qa/check as query) (empty? resource-ids)) query)))
        view-data)))


  Queryable
  (-refresh [as query] (refresh-impl/refresh as query))
  (-check [as query] (check-impl/check as query))
  (-add [as query] (add-impl/add as query))
  (-get [as query] (get-impl/get as query)))

(def defaults {:site-title "BLABLA"
               :view-type :loading-view
               :view-data {}
               :user {:name nil}
               :collections []
               :courses []
               :resources {}
               :queries #{}})
(defn new
  ([] (map->Appstate defaults))
  ([data]
   (map->Appstate (merge defaults data))))
