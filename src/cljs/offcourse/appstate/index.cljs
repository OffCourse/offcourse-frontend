(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.check :as check-impl]
            [offcourse.appstate.refresh :as refresh-impl]
            [offcourse.models.appstate.index :as model]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [schema.core :as schema]
            [cljs.core.async :refer [<! close! >!]]
            [offcourse.models.action :as action])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def actions {:requested-view        qa/refresh
              :found-data            qa/refresh
              :signed-in-user        qa/refresh
              :signed-out-user       qa/refresh
              :refreshed-credentials qa/refresh
              :requested-update      qa/refresh
              :requested-save        #(println %2)
              :found-profile         qa/refresh})

(defn -listener [{:keys [channels component-name reactions] :as as}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! (:input channels))]
      (when (type actions) ((type actions) as action))
      (recur))))

(schema/defrecord Appstate
    [component-name :- schema/Keyword
     channels       :- {}
     state          :- schema/Any]
  Lifecycle
  (start   [as] (ri/listen2 as))
  (stop    [as] (ri/mute as))
  Queryable
  (-check   [as query] (check-impl/check as query))
  (-refresh [as query] (refresh-impl/refresh as query))
  Responsive
  (-respond [as status payload] (ri/respond as status payload))
  (-mute [as] (ri/mute as))
  (-listen [as] (assoc as :listener (-listener as))))

(defn new [] (map->Appstate {:component-name :appstate
                             :state         (atom (model/new {:site-title "Offcourse_"}))}))
