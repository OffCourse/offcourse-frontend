(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.check :as check-impl]
            [offcourse.appstate.refresh :as refresh-impl]
            [offcourse.appstate.redirect :as redirect-impl]
            [offcourse.models.appstate.index :as model]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.redirectable :as rd :refer [Redirectable]]
            [schema.core :as schema]
            [offcourse.views.helpers :as vh]))

(schema/defrecord Appstate
    [component-name :- schema/Keyword
     channels       :- {}
     state          :- schema/Any]
  Redirectable
  (-redirect [as destination] (redirect-impl/redirect as destination))
  (-redirect [as destination payload] (redirect-impl/redirect as destination payload))
  Lifecycle
  (start   [as] (ri/listen as))
  (stop    [as] (ri/mute as))
  Queryable
  (-check   [as query] (check-impl/check as query))
  (-refresh [as query] (refresh-impl/refresh as query))
  Responsive
  (-respond [as status payload] (ri/respond as status payload))
  (-mute [as] (ri/mute as))
  (-listen [as] (ri/listen as)))

(defn new [] (map->Appstate {:component-name :appstate
                             :state          (atom (model/new {:site-title "Offcourse_"}))
                             :reactions      {:requested-view        qa/refresh
                                              :found-data            qa/refresh
                                              :not-found-data        qa/refresh
                                              :fetched-auth-token    qa/refresh
                                              :removed-auth-token    qa/refresh
                                              :requested-update      qa/refresh
                                              :requested-save-user   qa/refresh
                                              :requested-save-course qa/refresh
                                              :found-profile         qa/refresh}}))

