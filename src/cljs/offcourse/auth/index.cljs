(ns offcourse.auth.index
  (:require cljsjs.auth0-lock
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.auth.authenticate :as ac]
            [offcourse.auth.get :as get]
            [shared.protocols.responsive :as ri :refer [Responsive]]
            [shared.protocols.validatable :as va]))


(defn init [{:keys [config] :as auth}]
  (assoc auth :provider (js/Auth0Lock. (:clientID config) (:domain config))))

(defrecord Auth []
  Lifecycle
  (start [auth]
    (comment "this should be a Queryable Method (again)")
    (let [auth-token (get/get-local-token auth {:auth-token nil})]
      (when auth-token
        (ri/respond auth [:granted {:auth-token auth-token}]))
      (-> auth
          init
          ri/listen)))
  (stop [auth] (ri/mute auth))
  Responsive
  (-respond [auth event] (ri/respond auth event))
  (-react [auth event] (ac/react auth event))
  (-mute [auth] (ri/mute auth))
  (-listen [auth] (ri/listen auth)))


(defn create [name] (-> {:component-name name}
                        map->Auth))
