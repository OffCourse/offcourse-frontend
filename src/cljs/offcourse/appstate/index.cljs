(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.add :as add-impl]
            [offcourse.appstate.check :as check-impl]
            [offcourse.appstate.refresh :as refresh-impl]
            [offcourse.appstate.validatable :as va-impl]
            [offcourse.models.appstate.index :as model]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(schema/defrecord Appstate
    [component-name :- schema/Keyword
     channels       :- {}
     state          :- schema/Any
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start   [as] (ri/listen as))
  (stop    [as] (ri/mute as))
  Queryable
  (-check   [as query] (check-impl/check as query))
  (-add  [as query] (add-impl/add as query))
  (-refresh [as query] (refresh-impl/refresh as query))
  Validatable
  (-valid?  [as] (va-impl/valid? as))
  Responsive
  (-respond [as status payload] (ri/respond as status payload))
  (-mute [as] (ri/mute as))
  (-listen [as] (ri/listen as)))

(defn new [] (map->Appstate {:component-name :appstate
                             :state         (atom (model/new {:site-title "Offcourse_"}))
                             :proposal      (atom (model/new {:site-title "Offcourse_"}))}))
