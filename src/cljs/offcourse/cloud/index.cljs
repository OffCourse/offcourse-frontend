(ns offcourse.cloud.index
  (:require cljsjs.aws-sdk-js
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.cloud.refresh :as refresh-impl]
            [schema.core :as schema]))

(def CognitoConstructor (.-CognitoIdentityCredentials js/AWS))

(defn init [{:keys [initial-config] :as cloud}]
  (let [credentials (CognitoConstructor. (clj->js initial-config))
        config (merge initial-config {:credentials credentials})]
    (.update js/AWS.config (clj->js config))
    (reset! (:config cloud) config)))

(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Queryable
  (-refresh [cloud query] (refresh-impl/refresh cloud query))
  Lifecycle
  (start [cloud]
    (init cloud)
    (ri/listen cloud))
  (stop [cloud] (ri/mute cloud))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->Cloud {:component-name :cloud
                          :config (atom {})}))

