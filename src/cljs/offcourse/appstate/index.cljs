(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.queryable :as qa-impl]
            [offcourse.appstate.validatable :as va-impl]
            [offcourse.models.appstate :as model]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]))

(schema/defrecord Appstate
    [component-name :- schema/Keyword
     channels       :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start   [as] (ri/listen (assoc as :state (atom (model/new)))))
  (stop    [as] (ri/mute as))
  Queryable
  (-check   [as query] #_(qa-impl/check as query))
  (-add  [as query] #_(qa-impl/add as query))
  (-refresh [as query] (qa-impl/refresh as query))
  Validatable
  (-valid?  [as] (va-impl/valid? as))
  Responsive
  (respond [as status payload] (ri/-respond as status payload))
  (mute [as] (ri/-mute as))
  (listen [as] (ri/-listen as)))

(defn new [] (map->Appstate {:component-name :appstate}))
