(ns offcourse.api.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.api.queryable :as qa-impl]
            [com.stuartsierra.component :as lc]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(def actions {:not-found-data qa/fetch})

(defn -listener [{:keys [channels component-name reactions] :as api}]
  (go-loop []
    (let [{:keys [type source payload] :as action} (<! (:input channels))]
      (when (type actions) ((type actions) api payload))
      (recur))))

(defn connect-to-repository [{:keys [adapter name endpoint]}]
  (lc/start (adapter name endpoint)))

(schema/defrecord API
    [component-name :- schema/Keyword
     repositories   :- [schema/Any]
     channels       :- {}
     actions        :- []
     reactions      :- {}
     fetchables     :- {}]
  Lifecycle
  (start [api] (ri/listen2 (update api :repositories #(map connect-to-repository %))))
  (stop [api] (ri/mute api))
  Queryable
  (-fetch [api query] (qa-impl/fetch api query))
  Responsive
  (-respond [api status payload] (ri/respond api status payload))
  (-respond [api status type result] (ri/respond api status type result))
  (-mute [api] (ri/mute api))
  (-listen [api] (assoc api :listener (-listener api))))

(defn new [] (map->API {:component-name :api}))
