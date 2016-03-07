(ns offcourse.models.appstate.index
  (:require [offcourse.models.appstate.check :as check-impl]
            [offcourse.models.appstate.get :as get-impl]
            [offcourse.models.appstate.add :as add-impl]
            [offcourse.models.appstate.missing-data :as md-impl]
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
  (-missing-data [{:keys [view-data] :as as}] (md-impl/missing-data as (:type view-data)))


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
