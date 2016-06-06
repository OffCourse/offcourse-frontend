(ns offcourse.models.appstate.index
  (:require [offcourse.models.appstate.add :as add-impl]
            [offcourse.models.appstate.check :as check-impl]
            [offcourse.models.appstate.get :as get-impl]
            [offcourse.models.appstate.valid :as valid-impl]
            [offcourse.models.appstate.refresh :as refresh-impl]
            [offcourse.models.collection :refer [Collection]]
            [offcourse.models.course.index :as co :refer [Course]]
            [offcourse.models.resource.index :refer [Resource]]
            [offcourse.models.viewmodel.index :as vm]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(defn query [[type data]]
  {:type type
   type data})

(schema/defrecord Appstate
    [site-title     :- schema/Str
     viewmodel      :- schema/Any
     user           :- {:user-name (schema/maybe schema/Keyword)}
     auth-token     :- (schema/maybe schema/Str)
     collections    :- [Collection]
     courses        :- [Course]
     resources      :- (schema/maybe [Resource])
     queries        :- (schema/maybe #{schema/Num})]
  Validatable
  (-valid? [as] (valid-impl/valid? as Appstate))
  Queryable
  (-refresh [as query] (refresh-impl/refresh as query))
  (-check [as query] (check-impl/check as query))
  (-add [as query] (add-impl/add as query))
  (-get [as query] (get-impl/get as query)))

(def defaults {:site-title "BLABLA"
               :viewmodel {:type :loading}
               :user {:user-name nil}
               :collections []
               :courses []
               :resources []
               :queries #{}})

(defn new
  ([] (map->Appstate defaults))
  ([data]
   (map->Appstate (merge defaults data))))
